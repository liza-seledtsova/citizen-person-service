package com.citizen.person.service.country.impl;

import com.citizen.person.dto.CountryDto;
import com.citizen.person.entity.Country;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.ICountryMapper;
import com.citizen.person.repository.CountryRepository;
import com.citizen.person.service.country.ICountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.citizen.person.enums.NameEntity.COUNTRY;

/**
 * The type Country service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService implements ICountryService {

    private final CountryRepository countryRepository;
    private final ICountryMapper countryMapper;

    @Override
    public List<CountryDto> getAll() {
        List<CountryDto> countries = countryRepository.findAll().stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toList());
        if (log.isDebugEnabled()) {
            log.debug("List of country: {}", countries.stream()
                    .map(CountryDto::getCountryCode)
                    .collect(Collectors.joining()));
        }
        return countries;
    }

    @Override
    public void save(CountryDto newCountry) {
        countryRepository.save(countryMapper.toEntity(newCountry));
        if (log.isDebugEnabled()) {
            log.debug("The country - {} deleted.", newCountry.getCountryCode());
        }
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(getCountryById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, COUNTRY.name()))
                .getId());
        if (log.isDebugEnabled()) {
            log.debug("The country - {} deleted.", id);
        }
    }

    @Override
    public CountryDto getById(Long id) {
        return countryMapper.toDto(getCountryById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, COUNTRY.name())));
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

}
