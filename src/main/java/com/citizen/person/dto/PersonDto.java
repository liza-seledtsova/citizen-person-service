package com.citizen.person.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * The person dto.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonDto {
    private Long id;
    private String firstName;
    private String surname;
    private String gender;
    private Date dateOfBirth;
    private List<AddressDto> address;

}
