package com.citizen.person.mapper;

import com.citizen.person.dto.StateDto;
import com.citizen.person.entity.State;

/**
 * The interface State mapper.
 */
public interface IStateMapper {

    /**
     * To entity state.
     *
     * @param dto the dto
     * @return the state
     */
    State toEntity(StateDto dto);

    /**
     * To dto state dto.
     *
     * @param entity the entity
     * @return the state dto
     */
    StateDto toDto(State entity);
}
