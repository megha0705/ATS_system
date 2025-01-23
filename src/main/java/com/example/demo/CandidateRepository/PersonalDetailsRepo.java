package com.example.demo.CandidateRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.CandidateDatabase.PersonalDetails;
@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails, Integer> {

}
