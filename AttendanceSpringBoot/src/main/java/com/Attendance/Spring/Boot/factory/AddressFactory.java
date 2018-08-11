package com.Attendance.Spring.Boot.factory;

import com.Attendance.Spring.Boot.modal.Address;

import java.util.Map;

public class AddressFactory {

    public static Address getAddress(Map<String,String> values, String id, String employeeNumber, String address)
    {
        Address factoryAddress = new Address.Builder()
                .id(id)
                .employeeNumber(employeeNumber)
                .address(address)
                .build();
        return factoryAddress;
    }
}
