package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp implements service  {
    @Autowired
    CandidateRepo repo;

    @Autowired
    ExtractedDataRepo exRepo;

    @Autowired
    JobRequirementRepo requirement;
    public ServiceImp() {
        System.out.println("ServiceImp Constructor - Beans Injected");
    }
    public void candidateDetail(String name , String email){
        CandidateEntity entity = new CandidateEntity();
        entity.setEmailAddress(email);
        entity.setFullName(name);
        repo.save(entity);
           
    }

    @Override
    public void ExtractedDataResume(String skills, String experience, String projects) {
        if(exRepo != null){
            System.out.println("ExtractedDataRepo injected correctly!");
        }else{
            System.out.println("error injecting");
        }
        ExtractedDataEntity entity = new ExtractedDataEntity();
        entity.setExperience(experience);
        entity.setProjects(projects);
        entity.setSkill(skills);
        exRepo.save(entity); 

    }

    @Override
    public void jobRequirementDetails(String jobTitle, String skills, int experience) {
      
        CriteriaEntity cEntity = new CriteriaEntity();
        cEntity.setJobTitle(jobTitle);
        cEntity.setSkill(skills);
        cEntity.setExperience(experience);
        requirement.save(cEntity);

    }

   
}
