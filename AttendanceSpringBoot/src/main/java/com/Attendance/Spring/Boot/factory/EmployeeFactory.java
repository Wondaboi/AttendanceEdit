package com.Attendance.Spring.Boot.factory;

import com.Attendance.Spring.Boot.modal.Employee;

import java.util.Map;

public class EmployeeFactory {
    public static Employee getEmployee(Map<String,String> values, String id, String employeeNumber, String name, String surname) {
        Employee factoryEmployee = new Employee.Builder()
                .id(id)
                .employeeNumber(employeeNumber)
                .name(name)
                .surname(surname)
                .build();
        return factoryEmployee;
    }
}
