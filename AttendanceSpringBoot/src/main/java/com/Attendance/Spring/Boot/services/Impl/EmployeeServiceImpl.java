package com.Attendance.Spring.Boot.services.Impl;

import com.Attendance.Spring.Boot.modal.Employee;
import com.Attendance.Spring.Boot.repository.EmployeeRepository;
import com.Attendance.Spring.Boot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employee readById(String id) {
        return employeeRepository.findOne(id);
    }
    @Override
    public Set<Employee> readAll() {
        Set<Employee> result = new HashSet<Employee>();
        while (employeeRepository.findAll().iterator().hasNext()) {
            result.add(employeeRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public void delete(Employee id) { employeeRepository.delete(id); }
}
