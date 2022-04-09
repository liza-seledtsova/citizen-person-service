package com.citizen.person.controller;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.service.country.ICountryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The country controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CountryController {
    private final ICountryService countryService;

    /**
     * Gets all state.
     *
     * @return the all state
     */
    @SneakyThrows
    @GetMapping("/country")
    public ResponseEntity getAllCountry() {
        return ResponseEntity
                .ok()
                .body(countryService.getAll());
    }

    /**
     * Gets state by id.
     *
     * @param countryId the state id
     * @return the state by id
     */
    @GetMapping("/country/{countryId}")
    public ResponseEntity getCountryById(@PathVariable Long countryId) {
        return ResponseEntity
                .ok()
                .body(countryService.getById(countryId));
    }

    /**
     * Create state response entity.
     *
     * @param country the state
     * @return the response entity
     */
    @PostMapping("/country")
    public ResponseEntity createCountry(@RequestBody CountryDto country) {
        countryService.save(country);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping("/country")
    public ResponseEntity updateCountry(@RequestBody CountryDto country) {
        countryService.update(country);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Delete state response entity.
     *
     * @param countyId the state id
     * @return the response entity
     */
    @DeleteMapping("/country/{countyId}")
    public ResponseEntity deleteCountry(@PathVariable Long countyId) {
        countryService.delete(countyId);
        return ResponseEntity
                .ok()
                .build();
    }


}
