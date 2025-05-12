package com.global.holidays.dto;


public class CountryDto {
    private Integer id;
    private String countryName;
    private String code;

    public CountryDto() {
    }

    public CountryDto(Integer id, String countryName, String code) {
        this.id = id;
        this.countryName = countryName;
        this.code = code;
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
}