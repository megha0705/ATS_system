package com.example.demo;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CandidateDatabase.CandidateEducation;
import com.example.demo.CandidateDatabase.CandidateExperience;
import com.example.demo.CandidateDatabase.CandidateSkills;
import com.example.demo.CandidateDatabase.PersonalDetails;
import com.example.demo.CandidateRepository.CandidateEducationRepo;
import com.example.demo.CandidateRepository.CandidateExperienceRepo;
import com.example.demo.CandidateRepository.CandidateSkillRepo;
import com.example.demo.CandidateRepository.PersonalDetailsRepo;
import com.example.demo.DataMatching.AllDataMatching;
import com.example.demo.EmployerDB.JobRequirementEntity;
import com.example.demo.EmployerDB.JobRequirementRepo;
@Service
public class ServiceImp implements service  {
   @Autowired
    PersonalDetailsRepo personal_repo;
    
    @Autowired
    CandidateSkillRepo skill_Repo;

    @Autowired
    CandidateEducationRepo edu_repo;

    @Autowired
    CandidateExperienceRepo experienceRepo;

    @Autowired
    JobRequirementRepo  job_repo;

    @Autowired
    AllDataMatching dataMatch;
    /*@Autowired
    MatchingData m;*/

    public ServiceImp() {
        System.out.println("ServiceImp Constructor - Beans Injected");
    }

    int real_can_id = 0;

    //PERSONAL DETAILS

    public void candidateDetail(String name , String email){
       
        PersonalDetails pd = new PersonalDetails();
        
        pd.setCandidate_email(email);
        pd.setCandidate_name(name);
        
        personal_repo.save(pd);

        real_can_id = pd.getCandidate_id();
    }

    //SKILLS

    @Override
    public void candidateSkills(ArrayList<String> skills) {

       
                   
       PersonalDetails pd = personal_repo.findById(real_can_id).orElse(null); 

       if(pd == null){
        System.out.println("personal details object iis null" + real_can_id);
       }
       //List<String> existingSkills = skill_Repo.findSkillNameByCandidateId(real_can_id);
       ArrayList<CandidateSkills> cans = new ArrayList<>();
       for(String skill1 : skills){
       
            CandidateSkills skill = new CandidateSkills();
            skill.setSkillName(skill1);
            skill.setCandidateId(pd);
            cans.add(skill);
        
      
       }
       skill_Repo.saveAll(cans);

    }

    //EXPERIENCE

    @Override
    public void candidateExperience(String job_title, String company_name, double months_of_experience) {
        
       CandidateExperience can_exp = new CandidateExperience();

       PersonalDetails pd = personal_repo.findById(real_can_id).orElse(null); 

       can_exp.setCompany_name(company_name);
       can_exp.setJob_title(job_title);
       can_exp.setMonths_of_experience(months_of_experience);
       can_exp.setCandidate_id(pd);

       experienceRepo.save(can_exp);
    }

    //EDUCATION

    @Override
    public void candidateEducation(String degree_name) {
        CandidateEducation can_edu = new CandidateEducation();

        PersonalDetails pd = personal_repo.findById(real_can_id).orElse(null); 

        can_edu.setDegree_name(degree_name);
        can_edu.setCandidate_id(pd);

        edu_repo.save(can_edu);
       
    }

    @Override
    public void jobRequirementDetails(String jobTitle, String skills, int experience, String degree) {
       JobRequirementEntity job_entity = new JobRequirementEntity();

       job_entity.setJobTitle(jobTitle);
       job_entity.setDegree(degree);
       job_entity.setExperience_inMonths(experience);
       job_entity.setSkill(skills.toLowerCase());
       
       job_repo.save(job_entity);

       dataMatch.matchingRequirements(job_entity.getId());
       System.out.println("id has send succcesfully");

    }

   
 /*  

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
    }*/
}
