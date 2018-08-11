package com.Attendance.Spring.Boot.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable, Comparable<Address>{
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String employeeNumber;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return  "Address{" +
                "id='" + id + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Address address) {
        return id.compareTo(address.id);
    }

    public Address(Builder builder)
    {
        this.id = builder.id;
        this.employeeNumber = builder.employeeNumber;
        this.address = builder.address;

    }

    public static class Builder{
        private String id;
        private String employeeNumber;
        private String address;

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

        public Builder address(String value)
        {
            this.address = value;
            return this;
        }

        public Builder copy(Address address) {
            this.id = address.id;
            this.employeeNumber = address.employeeNumber;
            this.address = address.address;
            return  this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
