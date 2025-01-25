package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CandidateDatabase.CandidateSkills;
import com.example.demo.CandidateDatabase.PersonalDetails;
import com.example.demo.CandidateRepository.CandidateSkillRepo;
import com.example.demo.CandidateRepository.PersonalDetailsRepo;
@Service
public class ServiceImp implements service  {
   @Autowired
    PersonalDetailsRepo personal_repo;
    @Autowired
    ExtractedDataRepo exRepo;
    @Autowired
    CandidateSkillRepo skill_Repo;

    @Autowired
    JobRequirementRepo requirement;

    @Autowired
    MatchingData m;
    public ServiceImp() {
        System.out.println("ServiceImp Constructor - Beans Injected");
    }
    public void candidateDetail(String name , String email){
       
        PersonalDetails pd = new PersonalDetails();
        pd.setCandidate_email(email);
        pd.setCandidate_name(name);
        personal_repo.save(pd);
       
       
       
           
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
        if(m.matchingRequirements(cEntity.getId())){
            System.out.println("AHHHHHHHHHHHHHHHHHHHHH");
        }else{
            System.out.println("nahhhhhhhhhhhhhhhhhhhhhhh");
        }
    }
    @Override
    public void candidateSkills(String skills) {
        // TODO Auto-generated method stub
       PersonalDetails pd = new PersonalDetails();
       CandidateSkills skill = new CandidateSkills();
   
      skill.setSkill_name(skills);
       skill.setCandidate_id(pd);
       skill_Repo.save(skill);

    }

   
}
