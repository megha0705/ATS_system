package com.example.demo.CandidateRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CandidateDatabase.CandidateSkills;
@Repository
public interface CandidateSkillRepo extends JpaRepository<CandidateSkills, Integer>{

}