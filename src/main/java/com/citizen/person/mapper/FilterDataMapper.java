package com.citizen.person.mapper;

import com.citizen.person.dto.FilterDataDto;
import com.citizen.person.entity.Address;
import com.citizen.person.entity.Person;
import com.citizen.person.mapper.impl.IFilterDataMapper;
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
    public List<FilterDataDto> generateFilterFacetValue(List<Person> persons) {
        return !persons.isEmpty() ? List.of(buildFirstNameFacets(persons),
                buildSurnameFacets(persons),
                buildCountyCode(persons),
                buildAddressFacets(persons),
                buildCityFacets(persons),
                buildGenderFacets(persons),
                buildStateFacets(persons),
                buildDateOfBirthFacets(persons),
                buildAdditionAddressFacets(persons),
                buildCityFacets(persons))
                : new ArrayList<>();
    }

    /**
     * Build first name facets filter data dto.
     *
     * @param persons the persons
     * @return the filter data dto
     */
    public FilterDataDto buildFirstNameFacets(List<Person> persons) {
        return FilterDataDto.builder()
                .filterName(FIRST_NAME)
                .value(persons.stream()
                        .filter(person -> Strings.isNotBlank(person.getFirstName()))
                        .map(Person::getFirstName)
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
    public FilterDataDto buildSurnameFacets(List<Person> persons) {
        return FilterDataDto.builder()
                .filterName(SURNAME)
                .value(persons.stream()
                        .filter(person -> Strings.isNotBlank(person.getSurname()))
                        .map(Person::getSurname)
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
    public FilterDataDto buildAddressFacets(List<Person> persons) {
        return FilterDataDto.builder()
                .filterName(ADDRESS1)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getAddress1()))
                                .map(Address::getAddress1))
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
    public FilterDataDto buildAdditionAddressFacets(List<Person> persons) {
        return FilterDataDto.builder()
                .filterName(ADDRESS1)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getAddress2()))
                                .map(Address::getAddress1))
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
    public FilterDataDto buildCityFacets(List<Person> persons) {
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
    public FilterDataDto buildStateFacets(List<Person> persons) {
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
    public FilterDataDto buildPostCodeFacets(List<Person> persons) {
        return FilterDataDto.builder()
                .filterName(POSTCODE)
                .value(persons.stream()
                        .flatMap(person -> person.getAddress().stream()
                                .filter(address -> Strings.isNotBlank(address.getPostCode()))
                                .map(address -> address.getPostCode()))
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
    public FilterDataDto buildCountyCode(List<Person> persons) {
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
    public FilterDataDto buildGenderFacets(List<Person> persons) {
        return FilterDataDto.builder()
                .filterName(GENDER)
                .value(persons.stream()
                        .map(person -> person.getGender())
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
    public FilterDataDto buildDateOfBirthFacets(List<Person> persons) {
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
