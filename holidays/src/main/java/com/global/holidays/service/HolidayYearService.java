package com.global.holidays.service;

import com.global.holidays.dto.HolidayYearDto;
import com.global.holidays.model.HolidayYear;
import com.global.holidays.repository.HolidayYearRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayYearService {
    private final HolidayYearRepository holidayYearRepository;

    public HolidayYearService(HolidayYearRepository holidayYearRepository) {
        this.holidayYearRepository = holidayYearRepository;
    }

    public List<HolidayYearDto> getHolidayYearsByCountryNameAndYear(String countryName, int year) {
        List<HolidayYear> holidayYears = holidayYearRepository.findByCountryNameAndYear(countryName, year);
        return holidayYears.stream()
                .map(holidayYear -> new HolidayYearDto(
                        holidayYear.getId(),
                        holidayYear.getCountry().getCountryName(),
                        holidayYear.getHoliday().getHolidayName(),
                        holidayYear.getHoliday().getHolidayType().getTypeName(),
                        holidayYear.getSector() != null ? holidayYear.getSector().getSectorName() : "Genel",
                        holidayYear.getStartDate(),
                        holidayYear.getDurationDays()
                )).collect(Collectors.toList());
    }
}