package com.Attendance.Spring.Boot.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employee implements Serializable, Comparable<Employee>{
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String employeeNumber;
    private String name;
    private String surname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private Employee(Builder builder)
    {
        this.id = builder.id;
        this.employeeNumber = builder.employeeNumber;
        this.name = builder.name;
        this.surname = builder.surname;

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "FitnessBio{" +
                "id='" + id + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return id.compareTo(employee.id);
    }

    public static class Builder{
        private String id;
        private String employeeNumber;
        private String name;
        private String surname;

        public Builder id(String value)
        {
            this.id = value;
            return this;
        }

        public Builder employeeNumber(String value)
        {
            this.employeeNumber = value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder copy(Employee employee) {
            this.id = employee.id;
            this.employeeNumber = employee.employeeNumber;
            this.name = employee.name;
            this.surname = employee.surname;
            return  this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
