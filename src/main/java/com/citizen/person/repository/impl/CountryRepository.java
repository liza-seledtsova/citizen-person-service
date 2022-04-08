package com.citizen.person.repository.impl;

import com.citizen.person.entity.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Country repository.
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
}
