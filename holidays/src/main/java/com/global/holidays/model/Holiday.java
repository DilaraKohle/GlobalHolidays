package com.global.holidays.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="holidays")
public class Holiday {

    @Id
    private Integer id;

    @Column(name = "holiday_name", nullable = false)
    private String holidayName;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private HolidayType holidayType;

    @OneToMany(mappedBy = "holiday")
    private List<HolidayYear> holidayYears;

    @OneToMany(mappedBy = "holiday")
    private List<RegionHoliday> regionHolidays;

    public Holiday() {
    }

    public Holiday(Integer id, String holidayName, HolidayType holidayType, List<HolidayYear> holidayYears, List<RegionHoliday> regionHolidays) {
        this.id = id;
        this.holidayName = holidayName;
        this.holidayType = holidayType;
        this.holidayYears = holidayYears;
        this.regionHolidays = regionHolidays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }

    public List<HolidayYear> getHolidayYears() {
        return holidayYears;
    }

    public void setHolidayYears(List<HolidayYear> holidayYears) {
        this.holidayYears = holidayYears;
    }

    public List<RegionHoliday> getRegionHolidays() {
        return regionHolidays;
    }

    public void setRegionHolidays(List<RegionHoliday> regionHolidays) {
        this.regionHolidays = regionHolidays;
    }
}