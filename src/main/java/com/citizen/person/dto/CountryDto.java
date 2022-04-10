package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * The country dto.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CountryDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String countryCode;
}
