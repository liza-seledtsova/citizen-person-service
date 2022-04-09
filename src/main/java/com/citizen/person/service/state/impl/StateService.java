package com.citizen.person.service.state.impl;

import com.citizen.person.dto.StateDto;
import com.citizen.person.entity.State;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.IStateMapper;
import com.citizen.person.repository.StateRepository;
import com.citizen.person.service.state.IStateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.citizen.person.enums.NameEntity.COUNTRY;
import static com.citizen.person.enums.NameEntity.STATE;

/**
 * The person service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StateService implements IStateService {

    private final StateRepository stateRepository;
    private final IStateMapper stateMapper;

    @Override
    public List<StateDto> getAll() {
        List<StateDto> state = stateRepository.findAll().stream()
                .map(stateMapper::toDto)
                .collect(Collectors.toList());
        if (log.isDebugEnabled()) {
            log.debug("List of person: {}", state.stream()
                    .map(StateDto::getName)
                    .collect(Collectors.joining()));
        }
        return state;
    }

    @Override
    public void save(StateDto newState){
        stateRepository.save(stateMapper.toEntity(newState));
        if (log.isDebugEnabled()) {
            log.debug("The sate - {} created.", newState.getName());
        }
    }

    @Override
    @Transactional
    public void delete(Long stateId){
        stateRepository.deleteById(getStateById(stateId)
          .orElseThrow(() -> new EntityNotFoundException(stateId, COUNTRY.name()))
                .getId());
        if (log.isDebugEnabled()) {
            log.debug("The sate - {} deleted.", stateId);
        }
    }

    @Override
    public StateDto getById(Long id) {
        return stateMapper.toDto(getStateById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, STATE.name())));
    }
    @Override
    public Optional<State> getStateById(Long id) {
        return stateRepository.findById(id);
    }

}
