package com.citizen.person.repository;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.PersonDto;

import java.util.List;

/**
 * The interface Person filter repository.
 */
public interface PersonRepositoryCustom {
    /**
     * Persons filter list.
     *
     * @param filter   the filter
     * @param offSet   the off set  page
     * @param pageSize the page size
     * @return the list person
     */
    List<PersonDto> filter(List<FilterDataDto> filter, long offSet, int pageSize);
}
