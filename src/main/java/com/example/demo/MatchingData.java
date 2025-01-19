package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MatchingData {
 @Autowired
  ExtractedDataRepo exRepo;
  @Autowired
  JobRequirementRepo jobRepo;
  public boolean matchingRequirements(int jobId){
    
        CriteriaEntity criteria = jobRepo.findById(jobId)
        .orElseThrow(() -> new RuntimeException("Job not found"));
        List<ExtractedDataEntity>  candidates = exRepo.findBySkillsContaining(Arrays.asList(criteria.getSkill()));
        System.out.println("Criteria skill: " + criteria.getSkill());
        System.out.println("extracted skill: " + candidates);

        List<Integer> matchingScore = new ArrayList<>();
        for(ExtractedDataEntity candidate : candidates){
           // int score = 0;
            if(candidate.getSkill().contains(criteria.getSkill())){
               // score += 50;
            System.out.println(candidate.getId());   
          
            }
            
        }
        System.out.println("Number of candidates found: " + candidates.size());
        return true;

  }
}
