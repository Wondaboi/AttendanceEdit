package com.Attendance.Spring.Boot.client;

import com.Attendance.Spring.Boot.modal.Position;
import com.Attendance.Spring.Boot.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/positions")
public class PositionController {

    // Inject Service
    @Autowired
    private PositionService positionService;

    //-------------------Create a Position--------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPosition(@RequestBody Position position, UriComponentsBuilder ucBuilder) {
        positionService.create(position);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/positions/position/{id}").buildAndExpand(position.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Position--------------------------------------------------------
    @RequestMapping(value = "/position/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Position> getPosition(@PathVariable("id") String id) {
        Position position = positionService.readById(id);
        if (position == null) {
            return new ResponseEntity<Position>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Position>(position, HttpStatus.OK);
    }


    //-------------------Retrieve All Position--------------------------------------------------------

    @RequestMapping(value = "/position/AllPosition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Position>> getPosition() {
        Set<Position> positions = positionService.readAll();
        if(positions.isEmpty()){
            return new ResponseEntity<Set<Position>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Position>>(positions, HttpStatus.OK);
    }

    //------------------- Update a Position --------------------------------------------------------

    @RequestMapping(value = "/position/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Position> updatePosition(@PathVariable("id") String id, @RequestBody Position position) {

        Position currentPosition = positionService.readById(id);

        if (currentPosition==null) {
            return new ResponseEntity<Position>(HttpStatus.NOT_FOUND);
        }
        Position updatedPosition = new Position.Builder().copy(currentPosition)
                .id(position.getId())
                .employeeNumber(position.getEmployeeNumber())
                .position(position.getPosition())
                .build();
        positionService.update(updatedPosition);
        return new ResponseEntity<Position>(updatedPosition, HttpStatus.OK);
    }

    //------------------- Delete a Position --------------------------------------------------------

    @RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Position> deletePosition(@PathVariable("id") String id) {
        Position position = positionService.readById(id);
        if (position == null) {
            return new ResponseEntity<Position>(HttpStatus.NOT_FOUND);
        }
        positionService.delete(position);
        return new ResponseEntity<Position>(HttpStatus.NO_CONTENT);
    }
}
