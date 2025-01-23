package com.example.demo.CandidateRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CandidateDatabase.CandidateExperience;
@Repository
public interface CandidateExperienceRepo extends JpaRepository<CandidateExperience, Integer>{
    
}
