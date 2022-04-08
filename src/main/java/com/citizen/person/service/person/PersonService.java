package com.citizen.person.service.person;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PageImpl;
import com.citizen.person.entity.Person;
import com.citizen.person.mapper.impl.IFilterDataMapper;
import com.citizen.person.repository.impl.PersonRepository;
import com.citizen.person.service.person.impl.IPersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The person service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;
    private final IFilterDataMapper filterDataMapper;
    private final ObjectMapper objectMapper;

    @Override
    public List<Person> getAll() {
        List<Person> persons = personRepository.findAll();
        if (log.isDebugEnabled()) {
            log.debug("List of person: {}", persons.stream()
                    .map(person -> person.getFirstName() + " " + person.getSurname())
                    .collect(Collectors.joining()));
        }
        return persons;
    }

    @Override
    public List<FilterDataDto> generateFilerData(List<Person> persons) {
        return filterDataMapper.generateFilterFacetValue(persons);
    }

    @Override
    public FilterDto getPersonsFiltered(FilterDto filterDto, Pageable pageable) {
        if (log.isDebugEnabled()) {
            try {
                log.debug("The provided data: {}", objectMapper.writeValueAsString(filterDto));
            } catch (JsonProcessingException e) {
                log.error("Exception on the parsing process filerDro to JSON", e);
            }
        }
        filterDto.setResult(filterData(filterDto.getFilterDataDto(), pageable));
        return filterDto;
    }

    public PageImpl<Person> filterData(List<FilterDataDto> filter, Pageable pageable) {
        List<Person> persons = personRepository.filter(filter, pageable.isPaged() ? pageable.getSort() : Sort.unsorted(), pageable.getOffset(), pageable.getPageSize());
        return new PageImpl(persons, pageable.getPageNumber(), pageable.getPageSize(), new ObjectMapper().valueToTree(pageable), persons.size());
    }
}
