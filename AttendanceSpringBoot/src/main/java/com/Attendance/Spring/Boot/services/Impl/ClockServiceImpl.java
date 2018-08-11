package com.Attendance.Spring.Boot.services.Impl;

import com.Attendance.Spring.Boot.modal.Clock;
import com.Attendance.Spring.Boot.repository.ClockRepository;
import com.Attendance.Spring.Boot.services.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class ClockServiceImpl implements ClockService {

    @Autowired
    private ClockRepository clockRepository;
    @Override
    public Clock create(Clock clock) {
        return clockRepository.save(clock);
    }
    @Override
    public Clock readById(String id) {
        return clockRepository.findOne(id);
    }
    @Override
    public Set<Clock> readAll() {
        Set<Clock> result = new HashSet<Clock>();
        while (clockRepository.findAll().iterator().hasNext()) {
            result.add(clockRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Clock update(Clock clock) {
        return clockRepository.save(clock);
    }
    @Override
    public void delete(Clock id) { clockRepository.delete(id); }
}
