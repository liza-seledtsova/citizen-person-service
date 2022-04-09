package com.citizen.person.repository;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.PersonDto;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * The interface Person filter repository.
 */
public interface PersonRepositoryCustom {
    /**
     * Persons filter list.
     *
     * @param filter   the filter
     * @param sort     the sort
     * @param offSet   the off set  page
     * @param pageSize the page size
     * @return the list person
     */
    List<PersonDto> filter(List<FilterDataDto> filter, Sort sort, long offSet, int pageSize);
}
