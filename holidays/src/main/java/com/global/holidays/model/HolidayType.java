package com.global.holidays.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="holiday_types",uniqueConstraints = @UniqueConstraint(columnNames = "type_name"))
public class HolidayType {

    @Id
    private Integer id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @OneToMany(mappedBy = "holidayType")
    private List<Holiday> holidays;


    public HolidayType() {
    }

    public HolidayType(Integer id, String typeName, List<Holiday> holidays) {
        this.id = id;
        this.typeName = typeName;
        this.holidays = holidays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }
}