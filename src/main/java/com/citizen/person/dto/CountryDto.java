package com.citizen.person.dto;

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
    private Long id;
    private String countryCode;
}
