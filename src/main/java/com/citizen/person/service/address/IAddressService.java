package com.citizen.person.service.address;

import com.citizen.person.dto.AddressDto;

import java.util.List;

/**
 * The interface Address service.
 */
public interface IAddressService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<AddressDto> getAll();

    /**
     * Save.
     *
     * @param address the address
     */
    void save(AddressDto address);

    /**
     * Delete.
     *
     * @param addressId the address
     */
    void delete(Long addressId);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    AddressDto getById(Long id);
}
