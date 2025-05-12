package com.global.holidays.repository;

import com.global.holidays.model.RegionHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegionHolidayRepository extends JpaRepository<RegionHoliday, Integer> {
    //Country name için join ile birleştiridim.
    @Query("SELECT rh FROM RegionHoliday rh " +
            "JOIN rh.region r " +
            "JOIN r.country c " +
            "WHERE LOWER(c.countryName) = LOWER(:countryName) AND YEAR(rh.startDate) = :year")
    List<RegionHoliday> findByCountryNameAndYear(@Param("countryName") String countryName, @Param("year") int year);
}