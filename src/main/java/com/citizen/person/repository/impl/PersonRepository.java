package com.citizen.person.repository.impl;

import com.citizen.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Person repository.
 */
public interface PersonRepository extends JpaRepository<Person, String>, PersonRepositoryCustom {
    List<Person> findAll();
}
