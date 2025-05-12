package com.global.holidays.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="regions")
public class Region {

    @Id
    private Integer id;

    @Column(name = "region_name", nullable = false)
    private String regionName;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "region")
    private List<RegionHoliday> regionHolidays;


    public Region() {
    }

    public Region(Integer id, String regionName, Country country, List<RegionHoliday> regionHolidays) {
        this.id = id;
        this.regionName = regionName;
        this.country = country;
        this.regionHolidays = regionHolidays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<RegionHoliday> getRegionHolidays() {
        return regionHolidays;
    }

    public void setRegionHolidays(List<RegionHoliday> regionHolidays) {
        this.regionHolidays = regionHolidays;
    }
}