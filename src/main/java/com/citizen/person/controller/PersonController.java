package com.citizen.person.controller;

import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PageImpl;
import com.citizen.person.dto.PersonDto;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.service.person.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The person controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/persons")
public class PersonController {

    private final IPersonService personService;

    /**
     * Gets all persons.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the all persons
     */
    @GetMapping
    public ResponseEntity getAllPersons(@RequestParam int pageNumber, @RequestParam int pageSize) {
        List<PersonDto> persons = personService.getAll();
        return ResponseEntity
                .ok()
                .body(FilterDto.builder()
                        .result(new PageImpl(persons, pageNumber, pageSize, persons.size()))
                        .filterDataDto(personService.generateFilerData(persons)).build());
    }

    @GetMapping("/{personsId}")
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity getPersonById(@PathVariable Long personsId) {
        return ResponseEntity
                .ok()
                .body(personService.getById(personsId));
    }

    /**
     * Gets persons filtered.
     *
     * @param filterDto the filter dto
     * @return the persons filtered
     */
    @PostMapping("/filter")
    public ResponseEntity getPersonsFiltered(@RequestBody FilterDto filterDto) {
        Page page = filterDto.getResult();
        return ResponseEntity
                .ok().
                body(personService.getPersonsFiltered(filterDto,
                        new PageImpl(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements())));

    }

    /**
     * Create person response entity.
     *
     * @param person the person
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity createPerson(@RequestBody PersonDto person) {
        personService.save(person);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Update person response entity.
     *
     * @param person the person
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity updatePerson(@RequestBody PersonDto person) {
        personService.update(person);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Delete person response entity.
     *
     * @param personsId the persons id
     * @return the response entity
     */
    @DeleteMapping("/{personsId}")
    public ResponseEntity deletePerson(@PathVariable Long personsId) {
        personService.delete(personsId);
        return ResponseEntity
                .ok()
                .build();
    }

}
