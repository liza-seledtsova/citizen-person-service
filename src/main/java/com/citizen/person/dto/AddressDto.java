package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty
    private Long id;
    @JsonProperty
    private String address1;
    @JsonProperty
    private String address2;
    @JsonProperty
    private String postCode;
    @JsonProperty
    private CityDto city;
}
