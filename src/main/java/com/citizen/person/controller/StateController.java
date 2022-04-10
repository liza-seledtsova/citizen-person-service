package com.citizen.person.controller;

import com.citizen.person.dto.StateDto;
import com.citizen.person.service.state.IStateService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The state controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/state")
public class StateController {

    private final IStateService stateService;

    /**
     * Gets all state.
     *
     * @return the all state
     */
    @SneakyThrows
    @GetMapping
    public ResponseEntity getAllState() {
        return ResponseEntity
                .ok()
                .body(stateService.getAll());
    }

    /**
     * Gets state by id.
     *
     * @param stateId the state id
     * @return the state by id
     */
    @GetMapping("/{stateId}")
    public ResponseEntity getStateById(@PathVariable Long stateId) {
        return ResponseEntity
                .ok()
                .body(stateService.getById(stateId));
    }

    /**
     * Create state response entity.
     *
     * @param state the state
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity createState(@RequestBody StateDto state) {
        stateService.save(state);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Update person response entity.
     *
     * @param state the state
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity updateState(@RequestBody StateDto state) {
        stateService.update(state);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Delete state response entity.
     *
     * @param stateId the state id
     * @return the response entity
     */
    @DeleteMapping("/{stateId}")
    public ResponseEntity deleteState(@PathVariable Long stateId) {
        stateService.delete(stateId);
        return ResponseEntity
                .ok()
                .build();
    }

}
