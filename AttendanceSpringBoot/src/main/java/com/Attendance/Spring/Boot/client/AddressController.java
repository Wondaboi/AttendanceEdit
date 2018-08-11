package com.Attendance.Spring.Boot.client;

import com.Attendance.Spring.Boot.modal.Address;
import com.Attendance.Spring.Boot.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {

    // Inject Service
    @Autowired
    private AddressService addressService;

    //-------------------Create a Address--------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAddress(@RequestBody Address address, UriComponentsBuilder ucBuilder) {
        addressService.create(address);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addresss/address/{id}").buildAndExpand(address.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Address--------------------------------------------------------
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> getAddress(@PathVariable("id") String id) {
        Address address = addressService.readById(id);
        if (address == null) {
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }


    //-------------------Retrieve All Address--------------------------------------------------------

    @RequestMapping(value = "/address/AllAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Address>> getAddress() {
        Set<Address> addresss = addressService.readAll();
        if(addresss.isEmpty()){
            return new ResponseEntity<Set<Address>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Address>>(addresss, HttpStatus.OK);
    }

    //------------------- Update a Address --------------------------------------------------------

    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable("id") String id, @RequestBody Address address) {

        Address currentAddress = addressService.readById(id);

        if (currentAddress==null) {
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        Address updatedAddress = new Address.Builder().copy(currentAddress)
                .id(id)
                .employeeNumber(address.getEmployeeNumber())
                .address(address.getAddress())
                .build();
        addressService.update(updatedAddress);
        return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
    }

    //------------------- Delete a Address --------------------------------------------------------

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") String id) {
        Address address = addressService.readById(id);
        if (address == null) {
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        addressService.delete(address);
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }
}
