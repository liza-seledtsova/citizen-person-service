package com.citizen.person.mapper.impl;

import com.citizen.person.dto.PersonDto;
import com.citizen.person.entity.Person;
import com.citizen.person.mapper.IPersonMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PersonMapper implements IPersonMapper {

    private final ModelMapper mapper;

    @Override
    public Person toEntity(PersonDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Person.class);
    }

    @Override
    public PersonDto toDto(Person entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PersonDto.class);
    }

    @Override
    public Person merge(PersonDto dto, Person entity) {
        mapper.map(dto, entity);
        return entity;
    }
}
