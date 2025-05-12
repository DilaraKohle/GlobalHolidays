package com.global.holidays.repository;


import com.global.holidays.model.HolidayYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HolidayYearRepository extends JpaRepository<HolidayYear, Integer> {
    @Query("SELECT hy FROM HolidayYear hy WHERE LOWER(hy.country.countryName) = LOWER(:countryName) AND YEAR(hy.startDate) = :year")
    List<HolidayYear> findByCountryNameAndYear(@Param("countryName") String countryName, @Param("year") int year);
}