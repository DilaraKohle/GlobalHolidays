package com.global.holidays.service;

import com.global.holidays.dto.RegionHolidayDto;
import com.global.holidays.model.RegionHoliday;
import com.global.holidays.repository.RegionHolidayRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionHolidayService {
    private final RegionHolidayRepository regionHolidayRepository;

    public RegionHolidayService(RegionHolidayRepository regionHolidayRepository){
        this.regionHolidayRepository = regionHolidayRepository;
    }

    public List<RegionHolidayDto> getRegionHolidaysByCountryNameAndYear(String countryName, int year) {
        List<RegionHoliday> regionHolidays = regionHolidayRepository.findByCountryNameAndYear(countryName, year);
        return regionHolidays.stream()
                .map(regionHoliday -> new RegionHolidayDto(
                        regionHoliday.getId(),
                        regionHoliday.getRegion().getCountry().getCountryName(),
                        regionHoliday.getRegion().getRegionName(),
                        regionHoliday.getHoliday().getHolidayName(),
                        regionHoliday.getHoliday().getHolidayType().getTypeName(),
                        regionHoliday.getStartDate(),
                        regionHoliday.getDurationDays()
                ))
                .collect(Collectors.toList());
    }
}