package com.Attendance.Spring.Boot.factory;

import com.Attendance.Spring.Boot.modal.ContactDetails;

import java.util.Map;

public class ContactDetailsFactory {
    public static ContactDetails getContactDetails(Map<String,String> values, String id, String employeeNumber, String contactDetails)
    {
        ContactDetails factoryContactDetails = new ContactDetails.Builder()
                .id(id)
                .employeeNumber(employeeNumber)
                .contactDetails(contactDetails)
                .build();
        return factoryContactDetails;
    }
}
