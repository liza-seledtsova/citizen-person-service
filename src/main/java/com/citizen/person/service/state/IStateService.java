package com.citizen.person.service.state;

import com.citizen.person.dto.StateDto;
import com.citizen.person.entity.State;

import java.util.List;
import java.util.Optional;

/**
 * The interface Person service.
 */
public interface IStateService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<StateDto> getAll();

    /**
     * Save.
     *
     * @param newState the new state
     */
    void save(StateDto newState);


    /**
     * Update.
     *
     * @param updateState the update state
     */
    void update(StateDto updateState);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Long id);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    StateDto getById(Long id);

    /**
     * Gets state by id.
     *
     * @param id the id
     * @return the state by id
     */
    Optional<State> getStateById(Long id);
}
