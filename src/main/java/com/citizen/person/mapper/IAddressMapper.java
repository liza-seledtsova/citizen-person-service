package com.citizen.person.mapper;

import com.citizen.person.dto.AddressDto;
import com.citizen.person.entity.Address;

/**
 * The interface Address mapper.
 */
public interface IAddressMapper {

    /**
     * To entity address.
     *
     * @param dto the dto
     * @return the address
     */
    Address toEntity(AddressDto dto);

    /**
     * To dto address dto.
     *
     * @param entity the entity
     * @return the address dto
     */
    AddressDto toDto(Address entity);

    Address merge(AddressDto dto, Address entity);
}
