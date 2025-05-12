package com.global.holidays.controller;

import com.global.holidays.dto.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HolidaysPageController {

    @Autowired
    private RestTemplate restTemplate;

    //Tek bir ülkeyi koduna göre getir ve holidays sayfasına yönlendir
    @GetMapping("/countries/{code}")
    public String showCountryHolidays(@PathVariable("code") String code, Model model) {
        String url = "http://localhost:8080/api/countries/" + code;
        CountryDto country = restTemplate.getForObject(url, CountryDto.class);
        model.addAttribute("country", country);
        model.addAttribute("countryName", country.getCountryName());
        return "holidays";
    }

    //Arama işlemi arama parametresi ile ülke verilerini REST API'den almak
    @GetMapping("/holidays/search")
    public String searchCountries(@RequestParam("name") String query, Model model) {
        String url = "http://localhost:8080/api/countries/search?name=" + query;
        List<CountryDto> countries = restTemplate.getForObject(url, List.class);
        model.addAttribute("countries", countries);
        return "holidays";
    }
}