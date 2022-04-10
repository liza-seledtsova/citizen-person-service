package com.citizen.person.service.address.impl;

import com.citizen.person.dto.AddressDto;
import com.citizen.person.dto.CityDto;
import com.citizen.person.entity.Address;
import com.citizen.person.entity.City;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.IAddressMapper;
import com.citizen.person.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * The address service test.
 */
@ContextConfiguration(classes = {AddressService.class})
@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    @MockBean
    private IAddressMapper addressMapper;

    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    /**
     * Test update address not found.
     */
    @Test
    void testUpdateAddressNotFound() {
        AddressDto addressDto = AddressDto.builder()
                .id(1L)
                .address1("address1")
                .address2("address2")
                .postCode("postCode")
                .city(CityDto.builder()
                        .id(1L)
                        .name("name")
                        .build())
                .build();

        when(addressRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> addressService.update(addressDto));
    }

    /**
     * Test get address by id.
     */
    @Test
    void testGetAddressById() {
        Address address = new Address();
        address.setId(1L);
        address.setAddress1("address1");
        address.setAddress2("address2");
        address.setPostCode("postCode");

        when(addressRepository.findById(1L)).thenReturn(Optional.of(address));

        AddressDto addressDto = new AddressDto();
        addressDto.setId(1L);
        addressDto.setAddress1("address1");
        addressDto.setAddress2("address2");
        addressDto.setPostCode("postCode");

        when(addressMapper.toDto(address)).thenReturn(addressDto);

        AddressDto result = addressService.getById(1L);

        assertEquals(result, addressDto);
    }

    /**
     * Test get address by id not found.
     */
    @Test
    void testGetAddressByIdNotFound() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> addressService.getById(1L));
    }

    /**
     * Test get by id.
     */
    @Test
    void testGetById() {
        AddressDto addressDto = AddressDto.builder()
                .id(1L)
                .address1("address1")
                .address2("address2")
                .postCode("postCode")
                .city(CityDto.builder()
                        .id(1L)
                        .name("name")
                        .build())
                .build();

        Address address = Address.builder()
                .id(1L)
                .address1("address1")
                .address2("address2")
                .postCode("postCode")
                .city(City.builder()
                        .id(1L)
                        .name("name")
                        .build())
                .build();

        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(address));

        when(addressMapper.toDto(any())).thenReturn(addressDto);

        assertEquals(addressDto, addressService.getById(1L));

        verify(addressRepository, times(1)).findById(anyLong());

        verify(addressMapper, times(1)).toDto(any());

    }

    /**
     * Test get by id address not found.
     */
    @Test
    void testGetByIdAddressNotFound() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> addressService.getById(anyLong()));
    }

    /**
     * Test delete.
     */
    @Test
    void testDelete() {
        Long id = 1L;
        Address address = new Address();
        address.setId(id);
        when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        addressService.delete(id);
        verify(addressRepository, times(1)).deleteById(id);
    }

    /**
     * Test delete address not found.
     */
    @Test
    void testDeleteAddressNotFound() {
        Long addressId = 1L;
        when(addressRepository.findById(addressId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> addressService.delete(addressId));
    }

    /**
     * Test save.
     */
    @Test
    void testSave() {
        AddressDto addressDto = AddressDto.builder()
                .id(1L)
                .address1("address1")
                .address2("address2")
                .postCode("postCode")
                .city(CityDto.builder()
                        .id(1L)
                        .name("name")
                        .build())
                .build();

        Address address = Address.builder()
                .id(1L)
                .address1("address1")
                .address2("address2")
                .postCode("postCode")
                .city(City.builder()
                        .id(1L)
                        .name("name")
                        .build())
                .build();

        when(addressMapper.toEntity(addressDto)).thenReturn(address);

        addressService.save(addressDto);

        verify(addressRepository, times(1)).save(address);

    }

    /**
     * Test get all.
     */
    @Test
    void testGetAll() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(Address.builder().id(1L).address1("address1").build());
        addresses.add(Address.builder().id(2L).address1("address2").build());
        when(addressRepository.findAll()).thenReturn(addresses);

        List<AddressDto> addressDtos = new ArrayList<>();
        addressDtos.add(AddressDto.builder().id(1L).address1("address1").build());
        addressDtos.add(AddressDto.builder().id(2L).address1("address2").build());
        when(addressMapper.toDto(any())).thenReturn(addressDtos.get(0));

        List<AddressDto> result = addressService.getAll();

        assertEquals(2, result.size());
    }
}