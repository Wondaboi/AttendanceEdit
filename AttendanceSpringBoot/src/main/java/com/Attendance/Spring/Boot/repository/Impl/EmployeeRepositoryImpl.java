package com.Attendance.Spring.Boot.repository.Impl;

import com.Attendance.Spring.Boot.modal.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositoryImpl {
    private static EmployeeRepositoryImpl respository = null;

    private Map<String, Employee> employeeTable;

    private EmployeeRepositoryImpl() {
        employeeTable = new HashMap<String, Employee>();
    }

    public static EmployeeRepositoryImpl getInstance(){
        if(respository==null)
            respository = new EmployeeRepositoryImpl();
        return respository;
    }

    public Employee create(Employee employee) {
        employeeTable.put(employee.getId(),employee);
        Employee savedEmployee = employeeTable.get(employee.getId());
        return savedEmployee;
    }

    public Employee read(String id) {
        Employee employee = employeeTable.get(id);
        return employee;
    }

    public Employee update(Employee employee) {
        employeeTable.put(employee.getId(),employee);
        Employee savedEmployee = employeeTable.get(employee.getId());
        return savedEmployee;
    }

    public void delete(String id) {
        employeeTable.remove(id);

    }
}
