package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * The city dto.
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private StateDto state;

}
