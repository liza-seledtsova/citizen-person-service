package com.citizen.person.mapper.impl;

import com.citizen.person.dto.CityDto;
import com.citizen.person.entity.City;
import com.citizen.person.mapper.ICityMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CItyMapper implements ICityMapper {

    private final ModelMapper mapper;

    @Override
    public City toEntity(CityDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, City.class);
    }

    @Override
    public CityDto toDto(City entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CityDto.class);
    }
}
