package com.Attendance.Spring.Boot.repository;

import com.Attendance.Spring.Boot.modal.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Employee findOne(String id);
}
