package com.coldie.roommatebasicauth.service;

import com.coldie.roommatebasicauth.entity.Roommate;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface RoommateService {
    Iterable<Roommate> retrieveAllRoommate();

    Optional<Roommate> retrieveRoommateById(Long id);

    Iterable<Roommate> retrieveRoommateByLevel(int level);
}
