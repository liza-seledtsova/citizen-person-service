package com.citizen.person.repository;

import com.citizen.person.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Address repository.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAll();
}
