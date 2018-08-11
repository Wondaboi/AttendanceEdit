package com.Attendance.Spring.Boot.factory;

import com.Attendance.Spring.Boot.modal.Clock;

import java.util.Map;

public class ClockFactory {
    public static Clock getClock(Map<String,String> values, String id, String employeeNumber, String clockIn, String clockOut)
    {
        Clock factoryClock = new Clock.Builder()
                .id(id)
                .employeeNumber(employeeNumber)
                .clockIn(clockIn)
                .clockOut(clockOut)
                .build();
        return factoryClock;
    }
}
