package com.citizen.person.service.city;

import com.citizen.person.dto.CityDto;

import java.util.List;

/**
 * The interface City service.
 */
public interface ICityService {
    /**
     * Gets all.
     *
     * @return the all
     */
    List<CityDto> getAll();

    /**
     * Save.
     *
     * @param city the city
     */
    void save(CityDto city);

    /**
     * Delete.
     *
     * @param cityId the city
     */
    void delete(Long cityId);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    CityDto getById(Long id);
}
