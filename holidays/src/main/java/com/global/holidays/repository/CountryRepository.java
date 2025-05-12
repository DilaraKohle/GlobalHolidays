package com.global.holidays.repository;

import com.global.holidays.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    //Ülke ismine göre arama
    List<Country> findByCountryNameStartingWithIgnoreCase(String prefix);

    //Ülke koduna göre ülke bul
    Country findByCode(String code);
}