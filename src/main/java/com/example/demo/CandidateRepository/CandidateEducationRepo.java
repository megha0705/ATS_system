package com.example.demo.CandidateRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.CandidateDatabase.CandidateEducation;

public interface CandidateEducationRepo extends JpaRepository<CandidateEducation,Integer>{
    
}
