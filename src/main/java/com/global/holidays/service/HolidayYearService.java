package com.global.holidays.service;

import com.global.holidays.dto.HolidayYearDto;
import com.global.holidays.model.HolidayYear;
import com.global.holidays.repository.HolidayYearRepository;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
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
                .map(hy-> new HolidayYearDto(
                        hy.getCountry().getCountryName(),
                        hy.getHoliday().getHolidayName(),
                        hy.getHoliday().getHolidayType().getTypeName(),
                        hy.getSector() != null ? hy.getSector().getSectorName() : "Genel",
                        hy.getStartDate(),
                        hy.getDurationDays()
                )).collect(Collectors.toList());
    }

    public long calculateWorkingDays(String countryName, String sectorName, LocalDate startDate, LocalDate endDate){
        List<HolidayYear> holidays = holidayYearRepository.findByCountryNameAndDateRange(countryName, startDate, endDate);

        Set<LocalDate> holidayDates = holidays.stream()
                .filter(hy  -> hy.getSector() == null || (sectorName != null && hy.getSector().getSectorName().equalsIgnoreCase(sectorName)))
                .flatMap( hy  -> {
                    LocalDate start = hy.getStartDate();
                    return start.datesUntil(start.plusDays(hy.getDurationDays()));
                })
                .collect(Collectors.toSet());

        return startDate.datesUntil(endDate.plusDays(1))
                .filter(d -> !(d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY))
                .filter(d -> !holidayDates.contains(d))
                .count();
    }
}