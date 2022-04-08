package com.citizen.person.repository.impl;

import com.citizen.person.entity.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Address repository.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
