package com.Attendance.Spring.Boot.client;

import com.Attendance.Spring.Boot.modal.Clock;
import com.Attendance.Spring.Boot.services.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/clocks")
public class ClockController {

    // Inject Service
    @Autowired
    private ClockService clockService;

    //-------------------Create a Clock--------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createClock(@RequestBody Clock clock, UriComponentsBuilder ucBuilder) {
        clockService.create(clock);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/clocks/clock/{id}").buildAndExpand(clock.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Clock--------------------------------------------------------
    @RequestMapping(value = "/clock/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clock> getClock(@PathVariable("id") String id) {
        Clock clock = clockService.readById(id);
        if (clock == null) {
            return new ResponseEntity<Clock>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Clock>(clock, HttpStatus.OK);
    }


    //-------------------Retrieve All Clock--------------------------------------------------------

    @RequestMapping(value = "/clock/AllClock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Clock>> getClock() {
        Set<Clock> clocks = clockService.readAll();
        if(clocks.isEmpty()){
            return new ResponseEntity<Set<Clock>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Clock>>(clocks, HttpStatus.OK);
    }

    //------------------- Update a Clock --------------------------------------------------------

    @RequestMapping(value = "/clock/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Clock> updateClock(@PathVariable("id") String id, @RequestBody Clock clock) {

        Clock currentClock = clockService.readById(id);

        if (currentClock==null) {
            return new ResponseEntity<Clock>(HttpStatus.NOT_FOUND);
        }
        Clock updatedClock = new Clock.Builder().copy(currentClock)
                .id(clock.getId())
                .employeeNumber(clock.getEmployeeNumber())
                .clockIn(clock.getClockIn())
                .clockOut(clock.getClockOut())
                .build();
        clockService.update(updatedClock);
        return new ResponseEntity<Clock>(updatedClock, HttpStatus.OK);
    }

    //------------------- Delete a Clock --------------------------------------------------------

    @RequestMapping(value = "/clock/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Clock> deleteClock(@PathVariable("id") String id) {
        Clock clock = clockService.readById(id);
        if (clock == null) {
            return new ResponseEntity<Clock>(HttpStatus.NOT_FOUND);
        }
        clockService.delete(clock);
        return new ResponseEntity<Clock>(HttpStatus.NO_CONTENT);
    }
}
