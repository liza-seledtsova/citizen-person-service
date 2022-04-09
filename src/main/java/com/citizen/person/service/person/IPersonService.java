package com.citizen.person.service.person;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.FilterDto;
import com.citizen.person.dto.PersonDto;
import com.citizen.person.entity.Person;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * The interface Person service.
 */
public interface IPersonService {

    /**
     * Gets all persons.
     *
     * @return the persons
     */
    List<PersonDto> getAll();

    /**
     * Save.
     *
     * @param newPerson the new person
     */
    void save(PersonDto newPerson);

    /**
     * Delete.
     *
     * @param personId the person id
     */
    void delete(Long personId);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    PersonDto getById(Long id);

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    Optional<Person> getPersonById(Long id);

    /**
     * The method used for generation the filter data to provide
     * options for selection from a list of entity values.
     *
     * @param persons the persons
     * @return the list available filter data
     */
    List<FilterDataDto> generateFilerData(List<PersonDto> persons);

    /**
     * The method used to filter and sort data.
     *
     * @param filterDto the filter dto
     * @param pageable  the pageable
     * @return the persons filtered
     */
    FilterDto getPersonsFiltered(FilterDto filterDto, Pageable pageable);

}
