package com.citizen.person.controller;

import com.citizen.person.dto.AddressDto;
import com.citizen.person.service.address.IAddressService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The address controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/addresses")
public class AddressController {

    private final IAddressService addressService;

    /**
     * Gets all address.
     *
     * @return the all address
     */
    @SneakyThrows
    @GetMapping
    public ResponseEntity getAllAddress() {
        return ResponseEntity
                .ok().
                body(addressService.getAll());
    }

    /**
     * Gets address by id.
     *
     * @param addressId the address id
     * @return the address by id
     */
    @GetMapping("/{addressId}")
    public ResponseEntity getAddressById(@PathVariable Long addressId) {
        return ResponseEntity
                .ok()
                .body(addressService.getById(addressId));
    }

    /**
     * Create address response entity.
     *
     * @param address the address
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity createAddress(@RequestBody AddressDto address) {
        addressService.save(address);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Update address response entity.
     *
     * @param address the address
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity updateAddress(@RequestBody AddressDto address) {
        addressService.update(address);
        return ResponseEntity
                .ok()
                .build();
    }

    /**
     * Delete address response entity.
     *
     * @param addressId the address id
     * @return the response entity
     */
    @DeleteMapping("/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable Long addressId) {
        addressService.delete(addressId);
        return ResponseEntity.
                ok()
                .build();
    }

}
