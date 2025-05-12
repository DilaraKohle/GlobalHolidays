package com.global.holidays.controller;

import com.global.holidays.dto.CountryDto;
import com.global.holidays.service.CountryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    //Tüm ülkeleri getir
    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    //Arama kısmı için
    @GetMapping("/search")
    public List<CountryDto> searchCountries(@RequestParam("name") String query) {
        return countryService.searchCountriesByPrefix(query); //Ülke ismine göre arama yap
    }

    //Ülke koduna göre ülke detaylarını getir
    @GetMapping("/{code}")
    public CountryDto getCountryByCode(@PathVariable String code) {
        return countryService.getCountryByCode(code); //Kod ile ülke bilgilerini getir
    }
}