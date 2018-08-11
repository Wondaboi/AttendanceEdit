package com.Attendance.Spring.Boot.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Clock implements Serializable, Comparable<Clock>{
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String employeeNumber;
    private String clockIn;
    private String clockOut;

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

    public String getClockIn() {
        return clockIn;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    private Clock(Builder builder)
    {
        this.id = builder.id;
        this.employeeNumber = builder.employeeNumber;
        this.clockIn = builder.clockIn;
        this.clockOut = builder.clockOut;

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clock that = (Clock) o;

        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "Clock{" +
                "id='" + id + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", clockIn='" + clockIn + '\'' +
                ", clockOut='" + clockOut + '\'' +
                '}';
    }

    @Override
    public int compareTo(Clock clock) {
        return id.compareTo(clock.id);
    }

    public static class Builder{
        private String id;
        private String employeeNumber;
        private String clockIn;
        private String clockOut;

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

        public Builder clockIn(String value)
        {
            this.clockIn = value;
            return this;
        }

        public Builder clockOut(String value)
        {
            this.clockOut = value;
            return this;
        }

        public Builder copy(Clock clock) {
            this.id = clock.id;
            this.employeeNumber = clock.employeeNumber;
            this.clockIn = clock.clockIn;
            this.clockOut = clock.clockOut;
            return  this;
        }

        public Clock build(){
            return new Clock(this);
        }
    }

}
