package com.Attendance.Spring.Boot.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Position implements Serializable, Comparable<Position>{
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String employeeNumber;
    private String position;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Position(Builder builder)
    {
        this.id = builder.id;
        this.employeeNumber = builder.employeeNumber;
        this.position = builder.position;

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "FitnessBio{" +
                "id='" + id + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public int compareTo(Position position) {
        return id.compareTo(position.id);
    }

    public static class Builder{
        private String id;
        private String employeeNumber;
        private String position;

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

        public Builder position(String value)
        {
            this.position = value;
            return this;
        }

        public Builder copy(Position position) {
            this.id = position.id;
            this.employeeNumber = position.employeeNumber;
            this.position = position.position;
            return  this;
        }

        public Position build(){
            return new Position(this);
        }
    }
}
