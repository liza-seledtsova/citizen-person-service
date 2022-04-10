package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty
    private Long id;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String gender;
    @JsonProperty
    private Date dateOfBirth;
    @JsonProperty
    private List<AddressDto> address;

}
