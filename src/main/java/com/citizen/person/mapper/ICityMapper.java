package com.citizen.person.mapper;

import com.citizen.person.dto.CityDto;
import com.citizen.person.entity.City;

/**
 * The interface City mapper.
 */
public interface ICityMapper {

    /**
     * To entity city.
     *
     * @param dto the dto
     * @return the city
     */
    City toEntity(CityDto dto);

    /**
     * To dto city dto.
     *
     * @param entity the entity
     * @return the city dto
     */
    CityDto toDto(City entity);

    City merge(CityDto dto, City entity);
}
