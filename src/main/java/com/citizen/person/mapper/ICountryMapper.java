package com.citizen.person.mapper;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.entity.Country;

/**
 * The interface Country mapper.
 */
public interface ICountryMapper {

    /**
     * To entity country.
     *
     * @param dto the dto
     * @return the country
     */
    Country toEntity(CountryDto dto);

    /**
     * To dto country dto.
     *
     * @param entity the entity
     * @return the country dto
     */
    CountryDto toDto(Country entity);
}
