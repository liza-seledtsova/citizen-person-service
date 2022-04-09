package com.citizen.person.service.city.impl;

import com.citizen.person.dto.CityDto;
import com.citizen.person.dto.StateDto;
import com.citizen.person.entity.City;
import com.citizen.person.entity.State;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.ICityMapper;
import com.citizen.person.repository.CityRepository;
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
import static org.mockito.Mockito.*;


/**
 * The type City service test.
 */
@ContextConfiguration(classes = {CityService.class})
@ExtendWith(SpringExtension.class)
public class CityServiceTest {

    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private ICityMapper cityMapper;

    @Autowired
    private CityService cityService;

    /**
     * Test get by id not found.
     */
    @Test
    void testGetByIdNotFound() {
        Long id = 1L;
        when(cityRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> cityService.getById(id));
    }

    /**
     * Test save.
     */
    @Test
    void testSave() {
        CityDto cityDto = CityDto.builder()
                .id(1L)
                .name("Kiev")
                .state(StateDto.builder()
                        .id(1L)
                        .name("Ukraine")
                        .build())
                .build();

        City city = City.builder()
                .id(1L)
                .name("Kiev")
                .state(State.builder()
                        .id(1L)
                        .name("Ukraine")
                        .build())
                .build();

        when(cityMapper.toEntity(cityDto)).thenReturn(city);

        cityService.save(cityDto);

        verify(cityRepository, times(1)).save(city);
    }

    /**
     * Test delete.
     */
    @Test
    void testDelete() {
        CityDto cityDto = new CityDto();
        cityDto.setId(1L);
        cityDto.setName("Kiev");

        City city = new City();
        city.setId(1L);
        city.setName("Kiev");

        when(cityRepository.findById(1L)).thenReturn(Optional.of(city));
        when(cityMapper.toEntity(cityDto)).thenReturn(city);

        cityService.delete(1L);

        verify(cityRepository, times(1)).deleteById(1L);
    }

    /**
     * Test delete city not found.
     */
    @Test
    void testDeleteCityNotFound() {
        Long cityId = 1L;
        when(cityRepository.findById(cityId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> cityService.delete(cityId));
    }

    /**
     * Test get all.
     */
    @Test
    void testGetAll() {
        List<City> cities = new ArrayList<>();
        cities.add(City.builder().id(1L).name("Kiev").build());
        cities.add(City.builder().id(2L).name("Lviv").build());
        cities.add(City.builder().id(3L).name("Odessa").build());

        List<CityDto> cityDtos = new ArrayList<>();
        cityDtos.add(CityDto.builder().id(1L).name("Kiev").build());
        cityDtos.add(CityDto.builder().id(2L).name("Lviv").build());
        cityDtos.add(CityDto.builder().id(3L).name("Odessa").build());

        when(cityRepository.findAll()).thenReturn(cities);
        when(cityMapper.toDto(any())).thenReturn(cityDtos.get(0), cityDtos.get(1), cityDtos.get(2));

        List<CityDto> result = cityService.getAll();

        assertEquals(3, result.size());
    }
}