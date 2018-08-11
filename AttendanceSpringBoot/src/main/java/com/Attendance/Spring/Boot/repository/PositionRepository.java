package com.Attendance.Spring.Boot.repository;

import com.Attendance.Spring.Boot.modal.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, String> {
    Position findOne(String id);
}
