package com.citizen.person.mapper.impl;

import com.citizen.person.dto.StateDto;
import com.citizen.person.entity.State;
import com.citizen.person.mapper.IStateMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StateMapper implements IStateMapper {

    private final ModelMapper mapper;

    @Override
    public State toEntity(StateDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, State.class);
    }

    @Override
    public StateDto toDto(State entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, StateDto.class);
    }

    @Override
    public State merge(StateDto dto, State entity) {
        mapper.map(dto, entity);
        return entity;
    }
}
