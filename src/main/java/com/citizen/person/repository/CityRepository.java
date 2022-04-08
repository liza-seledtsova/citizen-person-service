package com.citizen.person.repository;

import com.citizen.person.entity.City;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface City repository.
 */
public interface CityRepository extends CrudRepository<City,String> {
}
