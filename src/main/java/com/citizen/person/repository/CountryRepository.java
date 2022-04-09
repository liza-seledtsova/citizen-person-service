package com.citizen.person.repository;

import com.citizen.person.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Country repository.
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();
}
