package com.Attendance.Spring.Boot.services.Impl;

import com.Attendance.Spring.Boot.modal.Position;
import com.Attendance.Spring.Boot.repository.PositionRepository;
import com.Attendance.Spring.Boot.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;
    @Override
    public Position create(Position position) {
        return positionRepository.save(position);
    }
    @Override
    public Position readById(String id) {
        return positionRepository.findOne(id);
    }
    @Override
    public Set<Position> readAll() {
        Set<Position> result = new HashSet<Position>();
        while (positionRepository.findAll().iterator().hasNext()) {
            result.add(positionRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Position update(Position position) {
        return positionRepository.save(position);
    }
    @Override
    public void delete(Position id) { positionRepository.delete(id); }
}
