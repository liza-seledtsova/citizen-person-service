package com.citizen.person.dto;

import lombok.*;

/**
 * The address dto.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressDto {
    private Long id;
    private String address1;
    private String address2;
    private String postCode;
    private CityDto city;
}
