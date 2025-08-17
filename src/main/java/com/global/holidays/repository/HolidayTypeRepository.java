package com.global.holidays.repository;

import com.global.holidays.model.HolidayType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HolidayTypeRepository extends JpaRepository<HolidayType, Integer>{
}
