package com.Attendance.Spring.Boot.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ContactDetails implements Serializable, Comparable<ContactDetails>{
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String employeeNumber;
    private String contactDetails;


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

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    private ContactDetails(Builder builder)
    {
        this.id = builder.id;
        this.employeeNumber = builder.employeeNumber;
        this.contactDetails = builder.contactDetails;

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDetails that = (ContactDetails) o;

        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "FitnessBio{" +
                "id='" + id + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }

    @Override
    public int compareTo(ContactDetails contactDetails) {
        return id.compareTo(contactDetails.id);
    }

    public static class Builder{
        private String id;
        private String employeeNumber;
        private String contactDetails;

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

        public Builder contactDetails(String value)
        {
            this.contactDetails = value;
            return this;
        }

        public Builder copy(ContactDetails contactDetails) {
            this.id = contactDetails.id;
            this.employeeNumber = contactDetails.employeeNumber;
            this.contactDetails = contactDetails.contactDetails;
            return  this;
        }

        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }
}
