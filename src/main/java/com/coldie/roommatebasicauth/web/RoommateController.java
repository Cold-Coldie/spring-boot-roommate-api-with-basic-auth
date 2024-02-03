package com.coldie.roommatebasicauth.web;

import com.coldie.roommatebasicauth.entity.Roommate;
import com.coldie.roommatebasicauth.exception.RoommateNotFoundException;
import com.coldie.roommatebasicauth.service.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RoommateController {
    @Autowired
    RoommateService roommateService;

    @GetMapping("/roommates")
    public ResponseEntity<Iterable<Roommate>> getRoommates() {
        Iterable<Roommate> roommates = roommateService.retrieveAllRoommate();
        return new ResponseEntity<Iterable<Roommate>>(roommates, HttpStatus.OK);
    }

    @GetMapping("/roommate/{id}")
    public ResponseEntity<Optional<Roommate>> getRoommateById(@PathVariable Long id) {
        try {
            Optional<Roommate> roommate = roommateService.retrieveRoommateById(id);
            if (roommate.isPresent()) {
                return new ResponseEntity<Optional<Roommate>>(roommate, HttpStatus.OK);
            } else {
                throw new RoommateNotFoundException("Roommate not found with id: " + id);
            }
        } catch (RoommateNotFoundException ex) {
            throw ex;
        }

    }

    @GetMapping("/roommate/level/{level}")
    public ResponseEntity<Iterable<Roommate>> getRoommateByLevel(@PathVariable int level) {
        Iterable<Roommate> roommate = roommateService.retrieveRoommateByLevel(level);
        return new ResponseEntity<Iterable<Roommate>>(roommate, HttpStatus.OK);
    }
}
