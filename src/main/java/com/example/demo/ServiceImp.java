package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp implements service {
    @Autowired
    CandidateRepo repo;
    @Autowired
    ExtractedDataRepo exRepo;
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
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'ExtractedDataResume'");
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

   
}
