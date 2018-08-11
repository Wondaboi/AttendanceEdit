package com.Attendance.Spring.Boot.repository;

import com.Attendance.Spring.Boot.modal.Clock;
import org.springframework.data.repository.CrudRepository;

public interface ClockRepository extends CrudRepository<Clock, String> {
    Clock findOne(String id);
}
