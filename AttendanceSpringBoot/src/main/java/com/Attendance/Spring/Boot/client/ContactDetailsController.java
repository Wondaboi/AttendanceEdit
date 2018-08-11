package com.Attendance.Spring.Boot.client;

import com.Attendance.Spring.Boot.modal.ContactDetails;
import com.Attendance.Spring.Boot.services.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/contactDetailss")
public class ContactDetailsController {

    // Inject Service
    @Autowired
    private ContactDetailsService contactDetailsService;

    //-------------------Create a ContactDetails--------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createContactDetails(@RequestBody ContactDetails contactDetails, UriComponentsBuilder ucBuilder) {
        contactDetailsService.create(contactDetails);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contactDetailss/contactDetails/{id}").buildAndExpand(contactDetails.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single ContactDetails--------------------------------------------------------
    @RequestMapping(value = "/contactDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactDetails> getContactDetails(@PathVariable("id") String id) {
        ContactDetails contactDetails = contactDetailsService.readById(id);
        if (contactDetails == null) {
            return new ResponseEntity<ContactDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ContactDetails>(contactDetails, HttpStatus.OK);
    }


    //-------------------Retrieve All ContactDetails--------------------------------------------------------

    @RequestMapping(value = "/contactDetails/AllContactDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ContactDetails>> getContactDetails() {
        Set<ContactDetails> contactDetailss = contactDetailsService.readAll();
        if(contactDetailss.isEmpty()){
            return new ResponseEntity<Set<ContactDetails>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<ContactDetails>>(contactDetailss, HttpStatus.OK);
    }

    //------------------- Update a ContactDetails --------------------------------------------------------

    @RequestMapping(value = "/contactDetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ContactDetails> updateContactDetails(@PathVariable("id") String id, @RequestBody ContactDetails contactDetails) {

        ContactDetails currentContactDetails = contactDetailsService.readById(id);

        if (currentContactDetails==null) {
            return new ResponseEntity<ContactDetails>(HttpStatus.NOT_FOUND);
        }
        ContactDetails updatedContactDetails = new ContactDetails.Builder().copy(currentContactDetails)
                .id(contactDetails.getId())
                .employeeNumber(contactDetails.getEmployeeNumber())
                .contactDetails(contactDetails.getContactDetails())
                .build();
        contactDetailsService.update(updatedContactDetails);
        return new ResponseEntity<ContactDetails>(updatedContactDetails, HttpStatus.OK);
    }

    //------------------- Delete a ContactDetails --------------------------------------------------------

    @RequestMapping(value = "/contactDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ContactDetails> deleteContactDetails(@PathVariable("id") String id) {
        ContactDetails contactDetails = contactDetailsService.readById(id);
        if (contactDetails == null) {
            return new ResponseEntity<ContactDetails>(HttpStatus.NOT_FOUND);
        }
        contactDetailsService.delete(contactDetails);
        return new ResponseEntity<ContactDetails>(HttpStatus.NO_CONTENT);
    }
}
