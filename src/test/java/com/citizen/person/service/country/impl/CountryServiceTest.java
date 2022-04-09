package com.citizen.person.service.country.impl;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.entity.Country;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.ICountryMapper;
import com.citizen.person.repository.CountryRepository;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * The country service test.
 */
@ContextConfiguration(classes = {CountryService.class})
@ExtendWith(SpringExtension.class)
public class CountryServiceTest {

    @MockBean
    private CountryRepository countryRepository;

    @MockBean
    private ICountryMapper countryMapper;

    @Autowired
    private CountryService countryService;

    /**
     * Test update country not found.
     */
    @Test
    void testUpdateCountryNotFound() {
        CountryDto updateCountryDto = CountryDto.builder()
                .id(1L)
                .countryCode("UA")
                .build();
        when(countryRepository.findById(updateCountryDto.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> countryService.update(updateCountryDto));
    }

    /**
     * Test get country by id.
     */
    @Test
    void testGetCountryById() {
        Country country = Country.builder()
                .id(1L)
                .countryCode("UA")
                .build();
        when(countryRepository.findById(1L)).thenReturn(Optional.of(country));
        when(countryMapper.toDto(country)).thenReturn(CountryDto.builder()
                .id(1L)
                .countryCode("UA")
                .build());

        CountryDto countryDto = countryService.getById(1L);

        assertEquals("UA", countryDto.getCountryCode());
    }

    /**
     * Test get country by id not found.
     */
    @Test
    void testGetCountryByIdNotFound() {
        when(countryRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> countryService.getById(anyLong()));
    }

    /**
     * Test get by id.
     */
    @Test
    void testGetById() {
        CountryDto countryDto = CountryDto.builder()
                .id(1L)
                .countryCode("UA")
                .build();

        Country country = Country.builder()
                .id(1L)
                .countryCode("UA")
                .build();

        when(countryRepository.findById(1L)).thenReturn(Optional.of(country));
        when(countryMapper.toDto(country)).thenReturn(countryDto);

        CountryDto result = countryService.getById(1L);

        assertEquals(countryDto, result);
    }

    /**
     * Test get by id not found.
     */
    @Test
    void testGetByIdNotFound() {
        when(countryRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> countryService.getById(anyLong()));
    }

    /**
     * Test delete.
     */
    @Test
    void testDelete() {
        CountryDto countryDto = CountryDto.builder()
                .id(1L)
                .countryCode("UA")
                .build();
        Country country = Country.builder()
                .id(1L)
                .countryCode("UA")
                .build();

        when(countryRepository.findById(countryDto.getId())).thenReturn(Optional.of(country));
        when(countryMapper.toEntity(countryDto)).thenReturn(country);

        countryService.delete(countryDto.getId());

        verify(countryRepository, times(1)).deleteById(countryDto.getId());
    }

    /**
     * Test delete country not found.
     */
    @Test
    void testDeleteCountryNotFound() {
        when(countryRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> countryService.delete(1L));
    }

    /**
     * Test save.
     */
    @Test
    void testSave() {
        CountryDto countryDto = CountryDto.builder()
                .id(1L)
                .countryCode("UA")
                .build();
        Country country = Country.builder()
                .id(1L)
                .countryCode("UA")
                .build();

        when(countryMapper.toEntity(countryDto)).thenReturn(country);

        countryService.save(countryDto);

        verify(countryRepository, times(1)).save(country);
    }

    /**
     * Test get all.
     */
    @Test
    void testGetAll() {
        Country country = Country.builder()
                .id(1L)
                .countryCode("UA")
                .build();
        CountryDto countryDto = CountryDto.builder()
                .id(1L)
                .countryCode("UA")
                .build();
        List<Country> countries = new ArrayList<>();
        countries.add(country);

        when(countryRepository.findAll()).thenReturn(countries);
        when(countryMapper.toDto(country)).thenReturn(countryDto);

        List<CountryDto> result = countryService.getAll();

        assertEquals(1, result.size());
        assertEquals("UA", result.get(0).getCountryCode());
    }
}