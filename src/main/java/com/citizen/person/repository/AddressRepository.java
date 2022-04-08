package com.citizen.person.repository;

import com.citizen.person.entity.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Address repository.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
