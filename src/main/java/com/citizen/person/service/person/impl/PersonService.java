package com.citizen.person.service.person.impl;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PageImpl;
import com.citizen.person.dto.PersonDto;
import com.citizen.person.entity.Person;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.IFilterDataMapper;
import com.citizen.person.mapper.IPersonMapper;
import com.citizen.person.repository.PersonRepository;
import com.citizen.person.service.person.IPersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.citizen.person.enums.NameEntity.CITY;
import static com.citizen.person.enums.NameEntity.PERSON;

/**
 * The person service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;
    private final IFilterDataMapper filterDataMapper;
    private final ObjectMapper objectMapper;
    private final IPersonMapper personMapper;

    @Override
    public PageImpl<PersonDto> getAll(Pageable pageable) {
        Page<Person> persons =personRepository.findAll(pageable);
        if (log.isDebugEnabled()) {
            log.debug("List of person: {}", persons.stream()
                    .map(person -> person.getFirstName() + " " + person.getSurname())
                    .collect(Collectors.joining()));
        }
        return new PageImpl(persons.getContent().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList()), pageable.getPageNumber(), pageable.getPageSize(), persons.getTotalElements());
    }

    @Override
    public void save(PersonDto newPerson) {
        personRepository.save(personMapper.toEntity(newPerson));
        if (log.isDebugEnabled()) {
            log.debug("New person saved {}", newPerson.getFirstName() + " " + newPerson.getSurname());
        }
    }

    @Override
    public void update(PersonDto updatePerson) {
        Long id = updatePerson.getId();
        personRepository.save(personMapper.merge(updatePerson, personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, PERSON.name()))));
        if (log.isDebugEnabled()) {
            log.debug("The person - {}  was updated.", updatePerson.getFirstName() + " " + updatePerson.getSurname());
        }
    }

    @Override
    public void delete(Long personId) {
        personRepository.deleteById(getPersonById(personId)
                .orElseThrow(() -> new EntityNotFoundException(personId, CITY.name()))
                .getId());
        if (log.isDebugEnabled()) {
            log.debug("Person deleted {}", personId);
        }
    }

    @Override
    public PersonDto getById(Long id) {
        return personMapper.toDto(getPersonById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, PERSON.name())));
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }


    @Override
    public List<FilterDataDto> generateFilerData(List<PersonDto> persons) {
        return filterDataMapper.generateFilterFacetValue(persons);
    }

    @Override
    public FilterDto getPersonsFiltered(FilterDto filterDto, PageImpl pageable) {
        if (log.isDebugEnabled()) {
            try {
                log.debug("The provided data: {}", objectMapper.writeValueAsString(filterDto));
            } catch (JsonProcessingException e) {
                log.error("Exception on the parsing process filerDro to JSON", e);
            }
        }
        filterDto.setResult(filterData(filterDto.getFilterDataDto(), pageable));
        return filterDto;
    }

    public PageImpl<PersonDto> filterData(List<FilterDataDto> filter, PageImpl pageable) {
        List<PersonDto> persons = personRepository.filter(filter, pageable.getPageable().getOffset(), pageable.getPageable().getPageSize());
        if (log.isDebugEnabled()) {
            log.debug("List of filtered persons: {}", persons.stream()
                    .map(person -> person.getFirstName() + " " + person.getSurname())
                    .collect(Collectors.joining()));
        }
        return new PageImpl(persons, pageable.getPageable().getPageNumber(), pageable.getPageable().getPageSize(), persons.size());
    }
}
