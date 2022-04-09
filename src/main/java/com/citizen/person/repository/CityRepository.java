package com.citizen.person.repository;

import com.citizen.person.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface City repository.
 */
public interface CityRepository extends CrudRepository<City,Long> {
    List<City> findAll();
}
