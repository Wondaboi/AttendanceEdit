package com.Attendance.Spring.Boot.client;

import com.Attendance.Spring.Boot.modal.Employee;
import com.Attendance.Spring.Boot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Inject Service
    @Autowired
    private EmployeeService employeeService;

    //-------------------Create a Employee--------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
        employeeService.create(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employees/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Employee--------------------------------------------------------
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
        Employee employee = employeeService.readById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


    //-------------------Retrieve All Employee--------------------------------------------------------

    @RequestMapping(value = "/employee/AllEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Employee>> getEmployee() {
        Set<Employee> employees = employeeService.readAll();
        if(employees.isEmpty()){
            return new ResponseEntity<Set<Employee>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Employee>>(employees, HttpStatus.OK);
    }

    //------------------- Update a Employee --------------------------------------------------------

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {

        Employee currentEmployee = employeeService.readById(id);

        if (currentEmployee==null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        Employee updatedEmployee = new Employee.Builder().copy(currentEmployee)
                .id(employee.getId())
                .employeeNumber(employee.getEmployeeNumber())
                .name(employee.getName())
                .surname(employee.getSurname())
                .build();
        employeeService.update(updatedEmployee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    //------------------- Delete a Employee --------------------------------------------------------

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String id) {
        Employee employee = employeeService.readById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(employee);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
