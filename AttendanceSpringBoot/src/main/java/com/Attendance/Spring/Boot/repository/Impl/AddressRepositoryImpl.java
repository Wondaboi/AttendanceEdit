package com.Attendance.Spring.Boot.repository.Impl;

import com.Attendance.Spring.Boot.modal.Address;

import java.util.HashMap;
import java.util.Map;

public class AddressRepositoryImpl {

    private static AddressRepositoryImpl respository = null;

    private Map<String, Address> addressTable;

    private AddressRepositoryImpl() {
        addressTable = new HashMap<String, Address>();
    }

    public static AddressRepositoryImpl getInstance(){
        if(respository==null)
            respository = new AddressRepositoryImpl();
        return respository;
    }

    public Address create(Address address) {
        addressTable.put(address.getId(),address);
        Address savedAddress = addressTable.get(address.getId());
        return savedAddress;
    }

    public Address read(String id) {
        Address address = addressTable.get(id);
        return address;
    }

    public Address update(Address address) {
        addressTable.put(address.getId(),address);
        Address savedAddress = addressTable.get(address.getId());
        return savedAddress;
    }

    public void delete(String id) {
        addressTable.remove(id);

    }
}
