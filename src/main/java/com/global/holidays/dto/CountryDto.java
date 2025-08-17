package com.global.holidays.dto;

public class CountryDto {
    private String countryName;
    private String code;

    public CountryDto() {
    }

    public CountryDto( String countryName, String code) {
        this.countryName = countryName;
        this.code = code;
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