package com.citizen.person.service.person.impl;

import com.citizen.person.dto.*;
import com.citizen.person.entity.*;
import com.citizen.person.enums.FilterName;
import com.citizen.person.enums.FilterType;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.IFilterDataMapper;
import com.citizen.person.mapper.IPersonMapper;
import com.citizen.person.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * The person service test.
 */
@ContextConfiguration(classes = {PersonService.class})
@ExtendWith(SpringExtension.class)
class PersonServiceTest {
    @MockBean
    private IFilterDataMapper filterDataMapper;

    @MockBean
    private IPersonMapper personMapper;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private ObjectMapper objectMapper;

    @Autowired
    private PersonService personService;

    /**
     * Test filter data.
     */
    @Test
    void testFilterData() {
        List<FilterDataDto> filter = new ArrayList<>();
        Pageable pageable = PageRequest.of(1, 10);
        PersonDto personDto = PersonDto.builder()
                .id(1L)
                .firstName("firstName")
                .surname("surname")
                .gender("gender")
                .dateOfBirth(new Date(Calendar.getInstance().getTime().getTime()))
                .address(new ArrayList<>())
                .build();
        List<PersonDto> persons = new ArrayList<>();
        persons.add(personDto);

        when(personRepository.filter(filter, pageable.getSort(), pageable.getOffset(), pageable.getPageSize())).thenReturn(persons);

        PageImpl<PersonDto> result = personService.filterData(filter, pageable);

        assertEquals(1, result.getContent().size());
    }

    /**
     * Test filter data with empty list.
     */
    @Test
    void testFilterDataWithEmptyList() {
        List<FilterDataDto> filter = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, 10);
        PageImpl<PersonDto> result = personService.filterData(filter, pageable);

        assertEquals(0, result.getTotalElements());
    }

    /**
     * Test get persons filtered with empty filter.
     */
    @Test
    void testGetPersonsFilteredWithEmptyFilter() {
        FilterDto filterDto = FilterDto.builder()
                .filterDataDto(Collections.emptyList())
                .build();
        Pageable pageable = PageRequest.of(0, 10);

        PageImpl<PersonDto> result = personService.getPersonsFiltered(filterDto, pageable).getResult();

        assertEquals(0, result.getTotalElements());
    }

    /**
     * Test generate filer data.
     */
    @Test
    void testGenerateFilerData() {
        List<PersonDto> persons = new ArrayList<>();
        persons.add(PersonDto.builder()
                .firstName("John")
                .surname("Smith")
                .gender("MALE")
                .dateOfBirth(new Date())
                .address(new ArrayList<>())
                .build());
        persons.add(PersonDto.builder()
                .firstName("John")
                .surname("Smith")
                .gender("MALE")
                .dateOfBirth(new Date())
                .address(new ArrayList<>())
                .build());

        List<FilterDataDto> filterDataDtos = new ArrayList<>();
        filterDataDtos.add(FilterDataDto.builder()
                .filterName(FilterName.FIRST_NAME)
                .filterType(FilterType.SELECT)
                .value(Arrays.asList("John"))
                .select(Arrays.asList("John"))
                .build());

        when(filterDataMapper.generateFilterFacetValue(persons)).thenReturn(filterDataDtos);

        List<FilterDataDto> result = personService.generateFilerData(persons);

        assertEquals(1, result.size());

    }

    /**
     * Test get by id.
     */
    @Test
    void testGetById() {
        PersonDto personDto = PersonDto.builder()
                .id(1L)
                .firstName("John")
                .surname("Smith")
                .gender("male")
                .dateOfBirth(new Date())
                .address(Collections.singletonList(AddressDto.builder()
                        .id(1L)
                        .city(CityDto.builder()
                                .id(1L)
                                .name("London")
                                .state(StateDto.builder()
                                        .id(1L)
                                        .name("test")
                                        .country(CountryDto.builder()
                                                .id(1L)
                                                .countryCode("UK")
                                                .build())
                                        .build())
                                .build())
                                .address1("Street 1")
                        .build()))
                .build();

                        when(personRepository.findById(1L)).thenReturn(Optional.of(personMapper.toEntity(personDto)));

        PersonDto result = personService.getById(1L);

        assertEquals(personDto, result);
    }

    /**
     * Test get by id person not found.
     */
    @Test
    void testGetByIdPersonNotFound() {
        Long id = 1L;
        when(personRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> personService.getById(id));
    }

    /**
     * Test delete.
     */
    @Test
    void testDelete() {
        personService.delete(1L);
        verify(personRepository, times(1)).deleteById(1L);
    }

    /**
     * Test delete person not found.
     */
    @Test
    void testDeletePersonNotFound() {
        Long personId = 1L;
        when(personRepository.findById(personId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> personService.delete(personId));
    }

    /**
     * Test save.
     */
    @Test
    void testSave() {
        PersonDto personDto = PersonDto.builder()
                .id(1L)
                .firstName("John")
                .surname("Smith")
                .gender("M")
                .dateOfBirth(new Date())
                .address(Collections.singletonList(AddressDto.builder()
                        .id(1L)
                        .city(CityDto.builder()
                                .id(1L)
                                .name("London")
                                .state(StateDto.builder()
                                        .id(1L)
                                        .name("test")
                                        .country(CountryDto.builder()
                                                .id(1L)
                                                .countryCode("UK")
                                                .build())
                                        .build()).build())
                        .address1("Street 1")
                        .build()))
                .build();

        Person person = Person.builder()
                .id(1L)
                .firstName("John")
                .surname("Smith")
                .gender("M")
                .dateOfBirth(new Date())
                .address(Collections.singletonList(Address.builder()
                        .id(1L)
                        .city(City.builder()
                                .id(1L)
                                .name("London")
                                .state(State.builder()
                                        .id(1L)
                                        .name("test")
                                        .country(Country.builder()
                                                .id(1L)
                                                .countryCode("UK")
                                                .build())
                                        .build()).build())
                        .address1("Street 1")
                        .build()))
                .build();

        when(personMapper.toEntity(personDto)).thenReturn(person);

        personService.save(personDto);

        verify(personRepository, times(1)).save(person);

    }

    /**
     * Test get all.
     */
    @Test
    void testGetAll() {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().id(1L).firstName("John").surname("Smith").build());
        persons.add(Person.builder().id(2L).firstName("John").surname("Smith").build());
        persons.add(Person.builder().id(3L).firstName("John").surname("Smith").build());
        when(personRepository.findAll()).thenReturn(persons);

        List<PersonDto> personDtos = new ArrayList<>();
        personDtos.add(PersonDto.builder().id(1L).firstName("John").surname("Smith").build());
        personDtos.add(PersonDto.builder().id(2L).firstName("John").surname("Smith").build());
        personDtos.add(PersonDto.builder().id(3L).firstName("John").surname("Smith").build());
        when(personMapper.toDto(any())).thenReturn(personDtos.get(0));

        List<PersonDto> result = personService.getAll();

        assertEquals(3, result.size());
    }
}