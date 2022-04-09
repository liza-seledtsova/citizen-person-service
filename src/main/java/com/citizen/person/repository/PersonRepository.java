package com.citizen.person.repository;

import com.citizen.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Person repository.
 */
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {
    List<Person> findAll();
}
