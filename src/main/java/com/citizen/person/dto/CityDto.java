package com.citizen.person.dto;

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
    private Long id;
    private String name;
    private StateDto state;

}
