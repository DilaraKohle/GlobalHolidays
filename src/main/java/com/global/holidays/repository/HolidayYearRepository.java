package com.global.holidays.repository;

import com.global.holidays.model.HolidayYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;


public interface HolidayYearRepository extends JpaRepository<HolidayYear, Integer> {
    @Query("Select hy From HolidayYear hy Where LOWER(hy.country.countryName) = LOWER(:countryName) And YEAR(hy.startDate) = :year")
    List<HolidayYear> findByCountryNameAndYear(@Param("countryName") String countryName, @Param("year") int year);

    @Query("Select hy From HolidayYear hy Where LOWER(hy.country.countryName) = LOWER(:countryName) And hy.startDate <= :endDate AND hy.startDate >= :startDate")
    List<HolidayYear> findByCountryNameAndDateRange(
            @Param("countryName") String countryName,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}