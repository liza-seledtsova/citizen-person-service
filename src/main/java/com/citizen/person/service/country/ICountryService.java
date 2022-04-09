package com.citizen.person.service.country;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.entity.Country;

import java.util.List;
import java.util.Optional;

/**
 * The interface Country service.
 */
public interface ICountryService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<CountryDto> getAll();

    /**
     * Save.
     *
     * @param newCountry the new country
     */
    void save(CountryDto newCountry);


    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Long id);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    CountryDto getById(Long id);

    /**
     * Gets country by id.
     *
     * @param id the id
     * @return the country by id
     */
    Optional<Country> getCountryById(Long id);

}
