package com.Attendance.Spring.Boot.repository.Impl;

import com.Attendance.Spring.Boot.modal.ContactDetails;

import java.util.HashMap;
import java.util.Map;

public class ContactDetailsRepositoryImpl {
    private static ContactDetailsRepositoryImpl respository = null;

    private Map<String, ContactDetails> contactDetailsTable;

    private ContactDetailsRepositoryImpl() {
        contactDetailsTable = new HashMap<String, ContactDetails>();
    }

    public static ContactDetailsRepositoryImpl getInstance(){
        if(respository==null)
            respository = new ContactDetailsRepositoryImpl();
        return respository;
    }

    public ContactDetails create(ContactDetails contactDetails) {
        contactDetailsTable.put(contactDetails.getId(),contactDetails);
        ContactDetails savedContactDetails = contactDetailsTable.get(contactDetails.getId());
        return savedContactDetails;
    }

    public ContactDetails read(String id) {
        ContactDetails contactDetails = contactDetailsTable.get(id);
        return contactDetails;
    }

    public ContactDetails update(ContactDetails contactDetails) {
        contactDetailsTable.put(contactDetails.getId(),contactDetails);
        ContactDetails savedContactDetails = contactDetailsTable.get(contactDetails.getId());
        return savedContactDetails;
    }

    public void delete(String id) {
        contactDetailsTable.remove(id);

    }
}
