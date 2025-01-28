package com.example.demo.DataMatching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CandidateDatabase.CandidateSkills;
import com.example.demo.CandidateDatabase.PersonalDetails;
import com.example.demo.CandidateRepository.CandidateSkillRepo;
import com.example.demo.EmployerDB.JobRequirementEntity;
import com.example.demo.EmployerDB.JobRequirementRepo;
import java.util.*;
@Service
public class AllDataMatching {
    @Autowired 
    CandidateSkillRepo skill_repo;
    @Autowired
    JobRequirementRepo job_repo;
    public void matchingRequirements(int job_id){
      
        
        JobRequirementEntity job_entity = job_repo.findById(job_id)
        .orElseThrow(() -> new IllegalArgumentException("JOB ID IS - >"+ job_id+" "+"it is null") );
        String individualSkill[] = job_entity.getSkill().split(",");
        ArrayList<ArrayList<CandidateSkills>> candidates = new ArrayList<>();
        for(int i = 0; i < individualSkill.length; i++){
            ArrayList<CandidateSkills> candidate = skill_repo.findBySkillNameContaining(individualSkill[i]);
            candidates.add(candidate);
        }

       
        System.out.println("this is the job id" + job_id);
        System.out.println("this is the job entity skills " + job_entity.getSkill());
        System.out.println("candidate skill isssssss" + candidates);
        for(CandidateSkills can : candidates){
            if(can.getSkillName().contains(job_entity.getSkill())){
                System.out.println("here is the list of personaldetails"   + can.getCandidateId());
            }else{
                System.out.println("noo it does not contain anything");
            }
         
        }
       
    }
}
