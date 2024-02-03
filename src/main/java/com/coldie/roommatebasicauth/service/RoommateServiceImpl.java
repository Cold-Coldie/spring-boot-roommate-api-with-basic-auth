package com.coldie.roommatebasicauth.service;

import com.coldie.roommatebasicauth.entity.Roommate;
import com.coldie.roommatebasicauth.respository.RoommateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoommateServiceImpl implements RoommateService {

    @Autowired
    RoommateRepository roommateRepository;

    public Iterable<Roommate> retrieveAllRoommate() {
        return roommateRepository.findAll();
    }

    public Optional<Roommate> retrieveRoommateById(Long id) {
        return roommateRepository.findById(id);
    }

    @Override
    public Iterable<Roommate> retrieveRoommateByLevel(int level) {
        return roommateRepository.findRoommateByLevel(level);
    }
}
