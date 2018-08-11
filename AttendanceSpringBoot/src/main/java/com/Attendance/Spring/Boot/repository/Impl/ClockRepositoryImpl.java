package com.Attendance.Spring.Boot.repository.Impl;

import com.Attendance.Spring.Boot.modal.Clock;

import java.util.HashMap;
import java.util.Map;

public class ClockRepositoryImpl {
    private static ClockRepositoryImpl respository = null;

    private Map<String, Clock> clockTable;

    private ClockRepositoryImpl() {
        clockTable = new HashMap<String, Clock>();
    }

    public static ClockRepositoryImpl getInstance(){
        if(respository==null)
            respository = new ClockRepositoryImpl();
        return respository;
    }

    public Clock create(Clock clock) {
        clockTable.put(clock.getId(),clock);
        Clock savedClock = clockTable.get(clock.getId());
        return savedClock;
    }

    public Clock read(String id) {
        Clock clock = clockTable.get(id);
        return clock;
    }

    public Clock update(Clock clock) {
        clockTable.put(clock.getId(),clock);
        Clock savedClock = clockTable.get(clock.getId());
        return savedClock;
    }

    public void delete(String id) {
        clockTable.remove(id);

    }
}
