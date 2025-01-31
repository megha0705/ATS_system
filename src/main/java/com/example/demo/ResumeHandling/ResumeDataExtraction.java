package com.example.demo.ResumeHandling;

import java.util.ArrayList;
import java.util.Arrays;

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
        String skillArray [] = skill.split("\\s*,\\s*");

        ArrayList<String> skills = new ArrayList<>(Arrays.asList(skillArray));
        s.candidateSkills(skills);
        
        //EXPERIENCE
       String company_name = exd.companyExtraction(resume);
       String job_title = exd.jobTitleExtraction(resume);
       double years = exd.yearsExtraction(resume);
       s.candidateExperience(job_title, company_name.trim(), years);

      //DEGREEE
       String eduDegree = ed.educationDegreeExtraction(resume);
       String eduArray[] = eduDegree.split("\\s*,\\s*");

       ArrayList<String> eduList = new ArrayList<>(Arrays.asList(eduArray));
       s.candidateEducation(eduList);


       System.out.println(skill );
       System.out.println(job_title);
       System.out.println(company_name.trim());
       System.out.println(years);
       System.out.println(eduDegree);

     
    }

}
