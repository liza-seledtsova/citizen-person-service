package com.citizen.person.dto;

import com.citizen.person.enums.FilterName;
import com.citizen.person.enums.FilterType;
import lombok.*;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * The filter data dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterDataDto {
    private Sort.Direction sorting;
    private boolean isSort;
    private List<String> value;
    private List<String> select;
    @NonNull
    private FilterName filterName;
    @NonNull
    private FilterType filterType;
    @Builder.Default
    private boolean groupBy = false;

}
