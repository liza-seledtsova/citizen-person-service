package com.citizen.person.service.state.impl;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.dto.StateDto;
import com.citizen.person.entity.Country;
import com.citizen.person.entity.State;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.IStateMapper;
import com.citizen.person.repository.StateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


/**
 * The type State service test.
 */
@ContextConfiguration(classes = {StateService.class})
@ExtendWith(SpringExtension.class)
public class StateServiceTest {

    @MockBean
    private StateRepository stateRepository;

    @MockBean
    private IStateMapper stateMapper;

    @Autowired
    private StateService stateService;

    /**
     * Test update not found.
     */
    @Test
    void testUpdateNotFound() {
        StateDto updateState = StateDto.builder()
                .id(1L)
                .name("test")
                .country(CountryDto.builder()
                        .id(1L)
                        .countryCode("UK")
                        .build())
                .build();

        when(stateRepository.findById(updateState.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> stateService.update(updateState));
    }

    /**
     * Test get state by id not found.
     */
    @Test
    void testGetStateByIdNotFound() {
        when(stateRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> stateService.getById(anyLong()));
    }

    /**
     * Test get by id not found.
     */
    @Test
    void testGetByIdNotFound() {
        when(stateRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> stateService.getById(anyLong()));
    }

    /**
     * Test save.
     */
    @Test
    void testSave() {
        StateDto stateDto = StateDto.builder()
                .id(1L)
                .name("test")
                .country(CountryDto.builder()
                        .id(1L)
                        .countryCode("UK")
                        .build())
                .build();

        State state = State.builder()
                .id(1L)
                .name("test")
                .country(Country.builder()
                        .id(1L)
                        .countryCode("UK")
                        .build())
                .build();

        when(stateMapper.toEntity(stateDto)).thenReturn(state);

        stateService.save(stateDto);

        verify(stateRepository, times(1)).save(state);
    }

    /**
     * Test delete.
     */
    @Test
    void testDelete() {
        Long id = 1L;
        State state = new State();
        state.setId(id);
        state.setName("test");
        when(stateRepository.findById(id)).thenReturn(Optional.of(state));
        stateService.delete(id);
        verify(stateRepository, times(1)).deleteById(id);
    }

    /**
     * Test delete not found.
     */
    @Test
    void testDeleteNotFound() {
        when(stateRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> stateService.delete(1L));
    }
}