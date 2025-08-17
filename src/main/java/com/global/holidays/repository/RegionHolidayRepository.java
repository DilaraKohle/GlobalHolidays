package com.global.holidays.repository;

import com.global.holidays.model.RegionHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RegionHolidayRepository extends JpaRepository<RegionHoliday, Integer> {
    @Query("Select rh From RegionHoliday rh " +
            "Join rh.region r " +
            "Join r.country c " +
            "Where LOWER(c.countryName) = LOWER(:countryName) And YEAR(rh.startDate) = :year")
    List<RegionHoliday> findByCountryNameAndYear(@Param("countryName") String countryName, @Param("year") int year);
}