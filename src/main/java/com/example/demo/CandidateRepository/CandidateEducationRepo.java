package com.example.demo.CandidateRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CandidateDatabase.CandidateEducation;
@Repository
public interface CandidateEducationRepo extends JpaRepository<CandidateEducation,Integer>{
    
}
