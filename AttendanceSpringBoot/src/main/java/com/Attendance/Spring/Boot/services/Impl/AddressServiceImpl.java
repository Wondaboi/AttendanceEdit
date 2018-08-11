package com.Attendance.Spring.Boot.services.Impl;


import com.Attendance.Spring.Boot.modal.Address;
import com.Attendance.Spring.Boot.repository.AddressRepository;
import com.Attendance.Spring.Boot.repository.Impl.AddressRepositoryImpl;
import com.Attendance.Spring.Boot.services.AddressService;
//import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }
    @Override
    public Address readById(String id) {
        return addressRepository.findOne(id);
    }
    @Override
    public Set<Address> readAll() {
        Set<Address> result = new HashSet<Address>();
        while (addressRepository.findAll().iterator().hasNext()) {
            result.add(addressRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }
    @Override
    public void delete(Address id) { addressRepository.delete(id); }
}
