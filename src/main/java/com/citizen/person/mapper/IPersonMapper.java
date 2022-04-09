package com.citizen.person.mapper;

import com.citizen.person.dto.PersonDto;
import com.citizen.person.entity.Person;

/**
 * The interface Person mapper.
 */
public interface IPersonMapper {

    /**
     * To entity person.
     *
     * @param dto the dto
     * @return the person
     */
    Person toEntity(PersonDto dto);

    /**
     * To dto person dto.
     *
     * @param entity the entity
     * @return the person dto
     */
    PersonDto toDto(Person entity);

    Person merge(PersonDto dto, Person entity);
}
