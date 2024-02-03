package com.coldie.roommatebasicauth.respository;

import com.coldie.roommatebasicauth.entity.Roommate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoommateRepository extends CrudRepository<Roommate, Long> {
    @Query("SELECT new com.coldie.roommatebasicauth.entity.Roommate(r.id, r.firstName, r.lastName, r.course, r.level) FROM Roommate r WHERE r.level = :level")
    Iterable<Roommate> findRoommateByLevel(int level);
}
