package com.citizen.person.mapper.impl;

import com.citizen.person.dto.AddressDto;
import com.citizen.person.entity.Address;
import com.citizen.person.mapper.IAddressMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AddressMapper implements IAddressMapper {

    private final ModelMapper mapper;

    @Override
    public Address toEntity(AddressDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Address.class);
    }

    @Override
    public AddressDto toDto(Address entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, AddressDto.class);
    }
}
