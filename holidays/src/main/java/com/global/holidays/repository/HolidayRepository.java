package com.global.holidays.repository;

import com.global.holidays.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
