package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * The state dto.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StateDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private CountryDto country;
}
