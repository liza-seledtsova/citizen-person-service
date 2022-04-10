package com.citizen.person.mapper.impl;

import com.citizen.person.dto.AddressDto;
import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.dto.PersonDto;
import com.citizen.person.mapper.IFilterDataMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.citizen.person.enums.FilterName.*;
import static com.citizen.person.enums.FilterType.RANGE;
import static com.citizen.person.enums.FilterType.SELECT;

/**
 * The filter data mapper.
 */
@Component
public class FilterDataMapper implements IFilterDataMapper {


    @Override
    public List<FilterDataDto> generateFilterFacetValue(List<PersonDto> persons) {
        return !persons.isEmpty() ? List.of(buildFirstNameFacets(persons),
                buildSurnameFacets(persons),
                buildCountyCode(persons),
                buildAddressFacets(persons),
                buildCityFacets(persons),
                buildGenderFacets(persons),
                buildStateFacets(persons),
                buildPostCodeFacets(persons),
                buildDateOfBirthFacets(persons),
                buildAdditionAddressFacets(persons))
                : new ArrayList<>();
    }

    /**
     * Build first name facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildFirstNameFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(FIRST_NAME)
                .value(persons.stream()
                        .filter(person -> Strings.isNotBlank(person.getFirstName()))
                        .map(PersonDto::getFirstName)
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build surname facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildSurnameFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(SURNAME)
                .value(persons.stream()
                        .filter(person -> Strings.isNotBlank(person.getSurname()))
                        .map(PersonDto::getSurname)
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build address facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildAddressFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(ADDRESS1)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getAddress1()))
                                .map(AddressDto::getAddress1))
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build addition address facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildAdditionAddressFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(ADDRESS1)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getAddress2()))
                                .map(AddressDto::getAddress1))
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build city facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildCityFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(CITY)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getCity().getName()))
                                .map(address -> address.getCity().getName()))
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build state facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildStateFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(STATE)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getCity().getState().getName()))
                                .map(address -> address.getCity().getState().getName()))
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build post code facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildPostCodeFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(POSTCODE)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getPostCode()))
                                .map(AddressDto::getPostCode))
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build county code filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildCountyCode(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(COUNTRY_CODE)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getCity().getState().getCountry().getCountryCode()))
                                .map(address -> address.getCity().getState().getCountry().getCountryCode()))
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build gender facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildGenderFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(GENDER)
                .value(persons.stream()
                        .map(PersonDto::getGender)
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(SELECT)
                .build();
    }

    /**
     * Build date of birth facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildDateOfBirthFacets(List<PersonDto> persons) {
        return FilterDataDto.builder()
                .filterName(DATE_OF_BIRTH)
                .value(persons.stream()
                        .map(person -> person.getDateOfBirth().toString())
                        .distinct()
                        .collect(Collectors.toList()))
                .filterType(RANGE)
                .build();
    }
}
