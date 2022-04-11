package com.citizen.person.controller;

import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PageImpl;
import com.citizen.person.dto.PersonDto;
import com.citizen.person.service.person.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        PageImpl<PersonDto> persons = personService.getAll(PageRequest.of(pageNumber, pageSize));
        FilterDto<PersonDto> filterDto = new FilterDto<>();
        filterDto.setResult(persons);
        filterDto.setFilterDataDto(personService.generateFilerData(persons.getContent()));
        return ResponseEntity
                .ok()
                .body(filterDto);
    }

    @GetMapping("/{personsId}")
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
