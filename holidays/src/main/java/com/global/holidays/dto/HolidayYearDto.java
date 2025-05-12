package com.global.holidays.dto;

import java.time.LocalDate;

public class HolidayYearDto {
    private Integer id;
    private String countryName;
    private String holidayName;
    private String holidayTypeName;
    private String sectorName;
    private LocalDate startDate;
    private int durationDays;

    public HolidayYearDto() {
    }

    public HolidayYearDto(Integer id, String countryName, String holidayName, String holidayTypeName, String sectorName, LocalDate startDate, int durationDays) {
        this.id = id;
        this.countryName = countryName;
        this.holidayName = holidayName;
        this.holidayTypeName = holidayTypeName;
        this.sectorName = sectorName;
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

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
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