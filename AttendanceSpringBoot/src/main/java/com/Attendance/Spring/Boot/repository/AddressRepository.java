package com.Attendance.Spring.Boot.repository;

import com.Attendance.Spring.Boot.modal.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
    Address findOne(String id);
}
