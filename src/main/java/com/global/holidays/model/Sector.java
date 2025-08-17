package com.global.holidays.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="sectors")
public class Sector {

    @Id
    private Integer id;

    @Column(name = "sector_name", nullable = false)
    private String sectorName;

    @OneToMany(mappedBy = "sector")
    private List<HolidayYear> holidayYears;

    public Sector() {
    }

    public Sector(Integer id, String sectorName, List<HolidayYear> holidayYears) {
        this.id = id;
        this.sectorName = sectorName;
        this.holidayYears = holidayYears;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public List<HolidayYear> getHolidayYears() {
        return holidayYears;
    }

    public void setHolidayYears(List<HolidayYear> holidayYears) {
        this.holidayYears = holidayYears;
    }
}