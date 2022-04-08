package com.citizen.person.repository;

import com.citizen.person.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Person repository.
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findAll();
}
