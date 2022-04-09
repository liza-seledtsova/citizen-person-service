package com.citizen.person.dto;

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
    private Long id;
    private String name;
    private CountryDto country;
}
