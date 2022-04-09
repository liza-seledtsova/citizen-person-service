package com.citizen.person.mapper.impl;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.entity.Country;
import com.citizen.person.mapper.ICountryMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CountryMapper implements ICountryMapper {

    private final ModelMapper mapper;

    @Override
    public Country toEntity(CountryDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Country.class);
    }

    @Override
    public CountryDto toDto(Country entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CountryDto.class);
    }

    @Override
    public Country merge(CountryDto dto, Country entity) {
        mapper.map(dto, entity);
        return entity;
    }
}
