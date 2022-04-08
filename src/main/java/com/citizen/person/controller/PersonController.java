package com.citizen.person.controller;

import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PageImpl;
import com.citizen.person.entity.Person;
import com.citizen.person.service.person.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The person controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class PersonController {

    private final IPersonService personService;
    private final ObjectMapper objectMapper;

    /**
     * Gets all persons.
     *
     * @param pageable the pageable
     * @return the all persons
     */
    @SneakyThrows
    @PostMapping("/persons")
    public ResponseEntity getAllPersons(@PageableDefault(sort = "firstName") Pageable pageable) {
        List<Person> persons = personService.getAll();
        return ResponseEntity.ok().body(FilterDto.builder().result(new PageImpl(persons, pageable.getPageNumber(), pageable.getPageSize(), objectMapper.valueToTree(pageable), persons.size())).filterDataDto(personService.generateFilerData(persons)).build());
    }

    /**
     * Gets persons filtered.
     *
     * @param filterDto the filter dto
     * @return the persons filtered
     */
    @PostMapping("/persons/filter")
    public ResponseEntity getPersonsFiltered(@RequestBody FilterDto filterDto) {
        return ResponseEntity.ok().body(personService.getPersonsFiltered(filterDto, filterDto.getResult().getPageable()));

    }
}
