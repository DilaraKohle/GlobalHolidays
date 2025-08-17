package com.global.holidays.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class Country {

    @Id
    private Integer id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "country")
    private List<HolidayYear> holidayYears;

    @OneToMany(mappedBy = "country")
    private List<Region> regions;


    public Country() {
    }

    public Country(Integer id, String countryName, String code, List<HolidayYear> holidayYears, List<Region> regions) {
        this.id = id;
        this.countryName = countryName;
        this.code = code;
        this.holidayYears = holidayYears;
        this.regions = regions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<HolidayYear> getHolidayYears() {
        return holidayYears;
    }

    public void setHolidayYears(List<HolidayYear> holidayYears) {
        this.holidayYears = holidayYears;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}