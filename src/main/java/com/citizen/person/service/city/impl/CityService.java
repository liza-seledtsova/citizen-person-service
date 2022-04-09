package com.citizen.person.service.city.impl;

import com.citizen.person.dto.CityDto;
import com.citizen.person.entity.City;
import com.citizen.person.exception.EntityNotFoundException;
import com.citizen.person.mapper.ICityMapper;
import com.citizen.person.repository.CityRepository;
import com.citizen.person.service.city.ICityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.citizen.person.enums.NameEntity.ADDRESS;
import static com.citizen.person.enums.NameEntity.CITY;

/**
 * The type City service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CityService implements ICityService {

    private final CityRepository cityRepository;
    private final ICityMapper cityMapper;

    @Override
    public List<CityDto> getAll() {
        List<CityDto> cities = cityRepository.findAll().stream()
                .map(cityMapper::toDto)
                .collect(Collectors.toList());
        if (log.isDebugEnabled()) {
            log.debug("List of city: {}", cities.stream()
                    .map(CityDto::getName)
                    .collect(Collectors.joining()));
        }
        return cities;
    }

    @Override
    public void save(CityDto newCity) {
        cityRepository.save(cityMapper.toEntity(newCity));
        if (log.isDebugEnabled()) {
            log.debug("The city - {} saved.", newCity.getName());
        }
    }

    @Override
    public void update(CityDto updateCityDto){
        Long id = updateCityDto.getId();
        cityRepository.save(cityMapper.merge(updateCityDto,cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, CITY.name()))));
    }

    @Override
    public void delete(Long cityId) {
        cityRepository.deleteById(getCityById(cityId)
                .orElseThrow(() -> new EntityNotFoundException(cityId, CITY.name()))
                .getId());
        if (log.isDebugEnabled()) {
            log.debug("The city - {} deleted.", cityId);
        }
    }

    @Override
    public CityDto getById(Long id) {
        return cityMapper.toDto(getCityById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, CITY.name())));
    }

    /**
     * Gets city by id.
     *
     * @param id the id
     * @return the city by id
     */
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

}
