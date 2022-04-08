package com.citizen.person.repository;

import com.citizen.person.entity.State;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface State repository.
 */
public interface StateRepository extends CrudRepository<State, String> {

}
