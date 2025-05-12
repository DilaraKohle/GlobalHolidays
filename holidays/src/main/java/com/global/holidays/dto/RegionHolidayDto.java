package com.global.holidays.dto;

import java.time.LocalDate;

public class RegionHolidayDto {
    private Integer id;
    private String countryName;
    private String regionName;
    private String holidayName;
    private String holidayTypeName;
    private LocalDate startDate;
    private int durationDays;

    public RegionHolidayDto() {
    }

    public RegionHolidayDto(Integer id, String countryName,String regionName, String holidayName, String holidayTypeName, LocalDate startDate, int durationDays) {
        this.id = id;
        this.countryName = countryName;
        this.regionName = regionName;
        this.holidayName = holidayName;
        this.holidayTypeName = holidayTypeName;
        this.startDate = startDate;
        this.durationDays = durationDays;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getHolidayTypeName() {
        return holidayTypeName;
    }

    public void setHolidayTypeName(String holidayTypeName) {
        this.holidayTypeName = holidayTypeName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
}