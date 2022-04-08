package com.citizen.person.repository.impl;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.entity.Person;
import com.citizen.person.repository.PersonRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

@Repository
@Slf4j
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    private final static String UNDER_SCORE = "_";

    @Override
    public List<Person> filter(List<FilterDataDto> filter, Sort sort, long offSet, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        predicateRootBuilder(criteriaBuilder, filter, root, criteriaQuery);
        criteriaQuery.orderBy(toOrders(sort, root, criteriaBuilder));
        criteriaQuery.distinct(true);
        TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
        long total = typedQuery.getResultList().size();
        typedQuery.setFirstResult((int) offSet);
        typedQuery.setMaxResults(pageSize);
        log.info("Search hints with filter data: {}", total);
        return  total > offSet ? typedQuery.getResultList() : Collections.<Person>emptyList();
    }

    private void predicateRootBuilder(CriteriaBuilder builder, List<FilterDataDto> filterData, Root<Person> root, CriteriaQuery<Person> criteriaQuery) {
        Predicate predicate = builder.conjunction();
        for (FilterDataDto param : filterData) {
            switch (param.getFilterType()) {
                case RANGE:
                    rangeQueryBuilder(builder, root, criteriaQuery, predicate, param);
                    break;
                case SELECT:
                    predicate = selectQueryBuilder(builder, root, criteriaQuery, param);
                    break;
                default:
                    log.warn("Invalid type of filer: {}, filed name {}", param.getFilterType(), param.getFilterName());
            }
        }
        criteriaQuery.where(predicate);
    }

    private Predicate selectQueryBuilder(CriteriaBuilder builder, Root<Person> root, CriteriaQuery<Person> criteriaQuery, FilterDataDto filterProperties) {
        List<String> query = filterProperties.getSelect();
        Predicate nestedPredicate = builder.conjunction();
        switch (filterProperties.getFilterName().getType()) {
            case NON_NESTED:
                nestedPredicate = wildcardQuery(builder, root, filterProperties, query, nestedPredicate, criteriaQuery);
                break;
            case NESTED:
                nestedPredicate = nestedWildcardQuery(builder, root, filterProperties, query, nestedPredicate, criteriaQuery);
                break;
            default:
                log.warn("Invalid type of nesting filer: {}, field name", filterProperties.getFilterName().getType(), filterProperties.getFilterName());
        }
        return nestedPredicate;

    }

    private Predicate nestedWildcardQuery(CriteriaBuilder builder, Root<Person> root, FilterDataDto param, List<String> query, Predicate nestedPredicate, CriteriaQuery<Person> criteriaQuery) {
        String complexKey = param.getFilterName().getValue();
        String newKey = complexKey.substring(complexKey.lastIndexOf(UNDER_SCORE) + 1);
        List<String> nestedEntity = new LinkedList<>(Arrays.asList(complexKey.split(UNDER_SCORE)));
        nestedEntity.remove(newKey);
        if (!nestedEntity.isEmpty()) {
            Join<Object, Object> join = joinBuilder(root, nestedEntity);
            if (!join.getJoins().isEmpty()) {
                join.getJoins().stream().reduce((prev, next) -> next).ifPresent(joinItem -> criteriaQuery.where(likeBuilder(builder, param.getSelect(), newKey, joinItem).toArray(new Predicate[0])));
            } else {
                nestedPredicate = builder.like(join.get(newKey), query.get(0));
            }
            if (param.isGroupBy()) {
                criteriaQuery.multiselect(join.get(newKey), builder.count(join.get(newKey)));
                criteriaQuery.groupBy(join.get(newKey));
            }
        }else log.info("Empty name field after parsing in entity {}", param.getFilterName());
        return nestedPredicate;
    }

    private List<Predicate> likeBuilder(CriteriaBuilder builder, List<String> selectedValue, String newKey, Join<Object, ?> join) {
        return selectedValue.stream().map(query -> builder.or(builder.like(join.get(newKey), query))).collect(Collectors.toList());
    }

    private Join<Object, Object> joinBuilder(Root<Person> root, List<String> nestedEntity) {
        Join<Object, Object> join = root.join(nestedEntity.get(0));
        nestedEntity.stream().skip(1).forEach(entity -> {
            join.join(entity);
        });
        return join;
    }

    private Predicate wildcardQuery(CriteriaBuilder builder, Root<Person> root, FilterDataDto param, List<String> query, Predicate nestedPredicate, CriteriaQuery<Person> criteriaQuery) {
        if (param.isGroupBy()) {
            String filterFiled = param.getFilterName().getValue();
            criteriaQuery.multiselect(root.get(filterFiled), builder.count(root.get(filterFiled)));
            criteriaQuery.groupBy(root.get(filterFiled));
        }
        return builder.and(nestedPredicate, builder.like(root.get(param.getFilterName().getValue()), "%" + query.get(0) + "%"));

    }

    private Predicate rangeQueryBuilder(CriteriaBuilder builder, Root<Person> root, CriteriaQuery<Person> criteriaQuery, Predicate predicate, FilterDataDto param) {
        Predicate greaterThanOrEqualTo = builder.greaterThanOrEqualTo(root.get(param.getFilterName().getValue()), param.getSelect().get(0));
        Predicate lessThanOrEqualTo = builder.lessThanOrEqualTo(root.get(param.getFilterName().getValue()), param.getSelect().get(1));
        if (Strings.isNotBlank(param.getValue().get(0))) {
            predicate = builder.and(predicate, greaterThanOrEqualTo);
        } else if (Strings.isNotBlank(param.getSelect().get(1))) {
            predicate = builder.and(predicate, lessThanOrEqualTo);
        } else if (param.getSelect().size() == 2) {
            predicate = builder.and(predicate, lessThanOrEqualTo, greaterThanOrEqualTo);
        }
        criteriaQuery.where(predicate);
        return predicate;
    }
}
