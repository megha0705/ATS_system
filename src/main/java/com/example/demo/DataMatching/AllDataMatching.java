package com.example.demo.DataMatching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CandidateDatabase.CandidateSkills;
import com.example.demo.CandidateDatabase.PersonalDetails;
import com.example.demo.CandidateRepository.CandidateSkillRepo;
import com.example.demo.CandidateRepository.PersonalDetailsRepo;
import com.example.demo.EmployerDB.JobRequirementEntity;
import com.example.demo.EmployerDB.JobRequirementRepo;
import java.util.*;
@Service
public class AllDataMatching {
    @Autowired 
    CandidateSkillRepo skill_repo;
    @Autowired
    JobRequirementRepo job_repo;
    @Autowired
    PersonalDetailsRepo personal_repo;
    public List<String> matchingRequirements(int job_id){
      
        
        JobRequirementEntity job_entity = job_repo.findById(job_id)
        .orElseThrow(() -> new IllegalArgumentException("JOB ID IS - >"+ job_id+" "+"it is null") );

       String []jobArray = job_entity.getSkill().split("\\s*,\\s*");

       List<String> skillList = new ArrayList<>(Arrays.asList(jobArray));
    
       List<String> can_names = personal_repo.findByCandidateExperienceAndSkillsAndEducation(job_entity.getJobTitle(),job_entity.getExperience_inMonths(),skillList, job_entity.getDegree());
       for(String name : can_names){
        System.out.println("THE NAME OF THE CANDIDATE  WITH THAT EXPERIENCE and  SKILL IS ->" +  name);
       }

       return can_names;
    }
}
