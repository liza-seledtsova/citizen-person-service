package com.citizen.person.dto;

import com.citizen.person.enums.FilterName;
import com.citizen.person.enums.FilterType;
import com.citizen.person.enums.Sorting;
import lombok.*;

import java.util.List;

import static com.citizen.person.enums.Sorting.ASC;

/**
 * The filter data dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterDataDto {
    @Builder.Default
    private Sorting sorting = ASC;
    private List<String> value;
    private List<String> select;
    @NonNull
    private FilterName filterName;
    @NonNull
    private FilterType filterType;
    @Builder.Default
    private boolean groupBy = false;

}
