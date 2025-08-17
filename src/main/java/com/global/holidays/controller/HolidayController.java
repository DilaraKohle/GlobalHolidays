package com.global.holidays.controller;

import com.global.holidays.dto.HolidayYearDto;
import com.global.holidays.dto.RegionHolidayDto;
import com.global.holidays.service.HolidayYearService;
import com.global.holidays.service.RegionHolidayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayYearService holidayYearService;
    private final RegionHolidayService regionHolidayService;

    public HolidayController(HolidayYearService holidayYearService, RegionHolidayService regionHolidayService) {
        this.holidayYearService = holidayYearService;
        this.regionHolidayService = regionHolidayService;
    }

    @GetMapping("/by-country")
    public ResponseEntity<Map<String, Object>> getHolidaysByCountry(
            @RequestParam String countryName,
            @RequestParam(required = false, defaultValue = "2025") int year) {

        List<HolidayYearDto> nationalHolidays = holidayYearService.getHolidayYearsByCountryNameAndYear(countryName, year);
        List<RegionHolidayDto> regionHolidays = regionHolidayService.getRegionHolidaysByCountryNameAndYear(countryName, year);

        Map<String, Object> response = new HashMap<>();
        response.put("Genel Tatiller", nationalHolidays);
        response.put("Bölgesel Tatiller", regionHolidays.isEmpty() ? "Bulunmamaktadır" : regionHolidays);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/working-days")
    public ResponseEntity<Map<String, Object>> getWorkingDaysBetweenDates(
            @RequestParam String countryName,
            @RequestParam(required = false) String sectorName,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        long workingDays = holidayYearService.calculateWorkingDays(countryName, sectorName, start, end);

        Map<String, Object> response = new HashMap<>();
        response.put("country", countryName);
        response.put("sector", sectorName != null ? sectorName : "Genel");
        response.put("startDate", start);
        response.put("endDate", end);
        response.put("workingDays", workingDays);

        return ResponseEntity.ok(response);
    }
}