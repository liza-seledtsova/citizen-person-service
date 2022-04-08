package com.citizen.person.service.person;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PageImpl;
import com.citizen.person.entity.Person;
import com.citizen.person.enums.FilterName;
import com.citizen.person.enums.FilterType;
import com.citizen.person.enums.Sorting;
import com.citizen.person.mapper.FilterDataMapper;
import com.citizen.person.mapper.impl.IFilterDataMapper;
import com.citizen.person.repository.impl.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonService.class})
@ExtendWith(SpringExtension.class)
class PersonServiceTest {
    @MockBean
    private IFilterDataMapper filterDataMapper;

    @MockBean
    private ObjectMapper objectMapper;

    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    void testGetAll() {
        ArrayList<Person> personList = new ArrayList<>();
        when(this.personRepository.findAll()).thenReturn(personList);
        List<Person> actualAll = this.personService.getAll();
        assertSame(personList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(this.personRepository).findAll();
    }

    @Test
    void testGenerateFilerData() {
        List<Person> persons = new ArrayList<>();
        Person person = Person.builder()
                .id(1L)
                .firstName("John")
                .surname("Doe")
                .gender("M")
                .dateOfBirth(Date.valueOf("2015-03-31"))
                .address(new ArrayList<>())
                .build();
        persons.add(person);

        when(personRepository.findAll()).thenReturn(persons);

        List<FilterDataDto> filterDataDtos = new ArrayList<>();
        FilterDataDto filterDataDto = FilterDataDto.builder()
                .filterName(FilterName.GENDER)
                .filterType(FilterType.SELECT)
                .groupBy(true)
                .sorting(Sorting.ASC)
                .value(new ArrayList<>())
                .select(new ArrayList<>())
                .build();

        filterDataDtos.add(filterDataDto);

        when(filterDataMapper.generateFilterFacetValue(persons)).thenReturn(filterDataDtos);

        List<FilterDataDto> result = personService.generateFilerData(persons);

        assertEquals(1, result.size());
    }

    @Test
    void testGetPersonsFiltered() {
        FilterDto filterDto = FilterDto.builder()
                .filterDataDto(Collections.singletonList(FilterDataDto.builder()
                        .filterName(FilterName.FIRST_NAME)
                        .filterType(FilterType.SELECT)
                        .value(Collections.singletonList("Bob"))
                        .build()))
                .result(new PageImpl<Person>(Collections.singletonList(Person.builder()
                        .firstName("Bob")
                        .surname("Long")
                        .build()), 1, 1, null, 1))
                .build();

        Pageable pageable = PageRequest.of(0, 10);

        when(personRepository.filter(any(), any(), anyInt(), anyInt())).thenReturn(Collections.singletonList(Person.builder()
                .firstName("Bob")
                .surname("Long")
                .build()));

        FilterDto result = personService.getPersonsFiltered(filterDto, pageable);

        assertEquals(filterDto, result);
    }


    @Test
    void testFilterData() {
        List<FilterDataDto> filter = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, 10);
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Bob");
        person.setSurname("Long");
        person.setGender("M");
        person.setDateOfBirth(Date.valueOf("2015-03-31"));
        persons.add(person);
        when(personRepository.filter(filter, pageable.getSort(), pageable.getOffset(), pageable.getPageSize())).thenReturn(persons);
        PageImpl<Person> result = personService.filterData(filter, pageable);
        assertEquals(1, result.getContent().size());
    }
}