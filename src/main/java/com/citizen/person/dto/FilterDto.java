package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.domain.Sort;

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
@EqualsAndHashCode
public class FilterDto implements Serializable {
    @JsonProperty
    private PageImpl<PersonDto> result;
    @JsonProperty
    @NonNull
    private List<FilterDataDto> filterDataDto;
    @JsonProperty
    private Sort.Direction sort;
    @JsonProperty
    private String selectedField;
}
