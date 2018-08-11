package com.Attendance.Spring.Boot.factory;

import com.Attendance.Spring.Boot.modal.Position;

import java.util.Map;

public class PositionFactory {
    public static Position getPosition(Map<String,String> values, String id, String employeeNumber, String position)
    {
        Position factoryPosition = new Position.Builder()
                .id(id)
                .employeeNumber(employeeNumber)
                .position(position)
                .build();
        return factoryPosition;
    }
}
