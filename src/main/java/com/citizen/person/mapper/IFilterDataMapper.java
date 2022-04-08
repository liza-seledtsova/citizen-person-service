package com.citizen.person.mapper;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.entity.Person;

import java.util.List;

/**
 * The interface Filter data mapper.
 */
public interface IFilterDataMapper {

    /**
     * Generate filter facet value list.
     *
     * @param persons the persons
     * @return the list
     */
    List<FilterDataDto> generateFilterFacetValue(List<Person> persons);
}
