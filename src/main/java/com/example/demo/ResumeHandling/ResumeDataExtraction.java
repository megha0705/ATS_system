package com.example.demo.ResumeHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service;

@Service
public class ResumeDataExtraction {
    //SERVICE FILE
    @Autowired 
    service s;
    //skillsDataExtraction file
    @Autowired
    SkillDataExtraction sd;
    // ExperienceDataExtraction file
    @Autowired
    ExperienceDataExtraction exd;
    //EducationExtraction file
    @Autowired
    EducationExtraction ed;

    public void dataExtraction(String resume){
        //SKILLS
        String skill = sd.skillExtraction(resume);
        s.candidateSkills(skill);
        
        //EXPERIENCE
       String company_name = exd.companyExtraction(resume);
       String job_title = exd.jobTitleExtraction(resume);
       double years = exd.yearsExtraction(resume);
       s.candidateExperience(job_title, company_name.trim(), years);

      //DEGREEE
       String eduDegree = ed.educationDegreeExtraction(resume);
       s.candidateEducation(eduDegree);


       System.out.println(skill );
       System.out.println(job_title);
       System.out.println(company_name.trim());
       System.out.println(years);
       System.out.println(eduDegree);

     
    }

}
