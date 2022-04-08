package com.citizen.person.dto;

import com.citizen.person.entity.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * The filter dto.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto implements Serializable {
    @JsonProperty
    @NonNull
    private PageImpl<Person> result;
    @JsonProperty
    @NonNull
    private List<FilterDataDto> filterDataDto;
    @JsonProperty
    private String selectedField;
}
