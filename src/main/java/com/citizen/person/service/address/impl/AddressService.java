package com.citizen.person.service.address.impl;

import com.citizen.person.dto.AddressDto;
import com.citizen.person.entity.Address;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.IAddressMapper;
import com.citizen.person.repository.AddressRepository;
import com.citizen.person.service.address.IAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.citizen.person.enums.NameEntity.ADDRESS;

/**
 * The address service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;
    private final IAddressMapper addressMapper;

    @Override
    public List<AddressDto> getAll() {
        List<AddressDto> address = addressRepository.findAll().stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
        if (log.isDebugEnabled()) {
            log.debug("List of address: {}", address.stream()
                    .map(AddressDto::getAddress1)
                    .collect(Collectors.joining()));
        }
        return address;
    }

    @Override
    public void save(AddressDto newAddress) {
        addressRepository.save(addressMapper.toEntity(newAddress));
        if (log.isDebugEnabled()) {
            log.debug("New address saved {}", newAddress.getId());
        }
    }

    @Override
    public void update(AddressDto updateAddressDto) {
        Long id = updateAddressDto.getId();
        addressRepository.save(addressMapper.merge(updateAddressDto, addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, ADDRESS.name()))));
        if (log.isDebugEnabled()) {
            log.debug("The address - {} was updated.", updateAddressDto.getId());
        }
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.deleteById(getAddressById(addressId)
                .orElseThrow(() -> new EntityNotFoundException(addressId, ADDRESS.name()))
                .getId());
        if (log.isDebugEnabled()) {
            log.debug("The address deleted {}", addressId);
        }
    }

    @Override
    public AddressDto getById(Long id) {
        return addressMapper.toDto(getAddressById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, ADDRESS.name())));
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

}
