package com.citizen.person.controller;

import com.citizen.person.dto.CityDto;
import com.citizen.person.service.city.ICityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The city controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cities")
public class CityController {

    private final ICityService cityService;

    /**
     * Gets all city.
     *
     * @return the all city
     */
    @SneakyThrows
    @GetMapping
    public ResponseEntity getAllCity() {
        return ResponseEntity.ok().body(cityService.getAll());
    }

    /**
     * Gets city by id.
     *
     * @param cityId the city id
     * @return the city by id
     */
    @GetMapping("/{cityId}")
    public ResponseEntity getCityById(@PathVariable Long cityId) {
        return ResponseEntity
                .ok()
                .body(cityService.getById(cityId));
    }


    /**
     * Create city response entity.
     *
     * @param city the city
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity createCity(@RequestBody CityDto city) {
        cityService.save(city);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Update city response entity.
     *
     * @param city the city
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity updateCity(@RequestBody CityDto city) {
        cityService.update(city);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Delete city response entity.
     *
     * @param cityId the city id
     * @return the response entity
     */
    @DeleteMapping("/{cityId}")
    public ResponseEntity deleteCity(@PathVariable Long cityId) {
        cityService.delete(cityId);
        return ResponseEntity
                .ok()
                .build();
    }

}
