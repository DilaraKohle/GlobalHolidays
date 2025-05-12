package com.global.holidays.service;

import com.global.holidays.dto.CountryDto;
import com.global.holidays.model.Country;
import com.global.holidays.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDto> getAllCountries() {
        return convertToDto(countryRepository.findAll());
    }

    public List<CountryDto> searchCountriesByPrefix(String prefix) {
        return convertToDto(countryRepository.findByCountryNameStartingWithIgnoreCase(prefix));
    }

    public CountryDto getCountryByCode(String code) {
        Country country = countryRepository.findByCode(code);
        if (country != null) {
            return new CountryDto(country.getId(), country.getCountryName(), country.getCode());
        }
        return null;
    }

    private List<CountryDto> convertToDto(List<Country> countries) {
        return countries.stream()
                .map(country -> new CountryDto(
                        country.getId(),
                        country.getCountryName(),
                        country.getCode()))
                .collect(Collectors.toList());
    }
}