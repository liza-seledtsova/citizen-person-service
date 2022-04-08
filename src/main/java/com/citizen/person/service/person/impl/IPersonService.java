package com.citizen.person.service.person.impl;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.FilterDto;
import com.citizen.person.entity.Person;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Person service.
 */
public interface IPersonService {

    /**
     * Gets all persons.
     *
     * @return the persons
     */
    List<Person> getAll();

    /**
     * The method used for generation the filter data to provide
     * options for selection from a list of entity values.
     *
     * @return the list available filter data
     */
    List<FilterDataDto> generateFilerData(List<Person> persons);

    /**
     * The method used to filter and sort data.
     *
     * @param filterDto the filter dto
     * @param pageable  the pageable
     * @return the persons filtered
     */
    FilterDto getPersonsFiltered(FilterDto filterDto, Pageable pageable);

}
