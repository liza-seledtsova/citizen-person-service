package com.citizen.person.service.filter.impl;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Filter service.
 */
public interface IFilterService {

    /**
     * The method used to build query filter and sort data,
     * determines the sort type { RANGE, SELECT}
     *
     * @param filter   the filter data
     * @param pageable the pageable
     * @return the page
     */
    PageImpl filter(List<FilterDataDto> filter, Pageable pageable);
}
