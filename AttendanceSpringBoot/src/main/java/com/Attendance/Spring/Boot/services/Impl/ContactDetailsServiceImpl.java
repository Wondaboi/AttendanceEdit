package com.Attendance.Spring.Boot.services.Impl;

import com.Attendance.Spring.Boot.modal.ContactDetails;
import com.Attendance.Spring.Boot.repository.ContactDetailsRepository;
import com.Attendance.Spring.Boot.services.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class ContactDetailsServiceImpl implements ContactDetailsService {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;
    @Override
    public ContactDetails create(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }
    @Override
    public ContactDetails readById(String id) {
        return contactDetailsRepository.findOne(id);
    }
    @Override
    public Set<ContactDetails> readAll() {
        Set<ContactDetails> result = new HashSet<ContactDetails>();
        while (contactDetailsRepository.findAll().iterator().hasNext()) {
            result.add(contactDetailsRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public ContactDetails update(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }
    @Override
    public void delete(ContactDetails id) { contactDetailsRepository.delete(id); }
}
