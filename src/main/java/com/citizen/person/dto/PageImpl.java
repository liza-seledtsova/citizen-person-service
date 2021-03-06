package com.citizen.person.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * The class Page for parsing json to page.
 *
 * @param <T> the type parameter
 */
public class PageImpl<T> extends org.springframework.data.domain.PageImpl<T> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PageImpl(@JsonProperty("content") List<T> content,
                    @JsonProperty("number") int page,
                    @JsonProperty("size") int size,
                    @JsonProperty("totalElements") long total) {

        super(content, PageRequest.of(page, size), total);
    }
}

