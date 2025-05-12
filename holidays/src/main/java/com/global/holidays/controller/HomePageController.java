package com.global.holidays.controller;

import com.global.holidays.dto.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private RestTemplate restTemplate;

    //Ana sayfa ülkeleri REST API'den almak
    @GetMapping("/")
    public String showHomePage(Model model) {
        List<CountryDto> countries = restTemplate.getForObject("http://localhost:8080/api/countries", List.class);
        model.addAttribute("countries", countries);
        return "index";  //Thymeleaf şablonunu render et
    }

    //Arama işlemi arama parametresi ile ülke verilerini REST API'den almak
    @GetMapping("/search")
    public String searchCountries(@RequestParam("name") String query, Model model) {
        String url = "http://localhost:8080/api/countries/search?name=" + query;
        List<CountryDto> countries = restTemplate.getForObject(url, List.class);
        model.addAttribute("countries", countries);
        return "index";  //Arama sonuçlarını göster
    }
}