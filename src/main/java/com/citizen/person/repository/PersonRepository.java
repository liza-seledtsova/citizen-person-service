package com.citizen.person.repository;

import com.citizen.person.dto.PageImpl;
import com.citizen.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * The interface Person repository.
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, PersonRepositoryCustom {
    List<Person> findAll();
}
