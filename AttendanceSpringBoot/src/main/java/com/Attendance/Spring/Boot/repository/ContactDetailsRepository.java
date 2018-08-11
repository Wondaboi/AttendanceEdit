package com.Attendance.Spring.Boot.repository;

import com.Attendance.Spring.Boot.modal.ContactDetails;
import org.springframework.data.repository.CrudRepository;

public interface ContactDetailsRepository extends CrudRepository<ContactDetails, String> {
    ContactDetails findOne(String id);
}
