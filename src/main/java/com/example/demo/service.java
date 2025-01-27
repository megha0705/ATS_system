package com.example.demo;

import com.example.demo.CandidateDatabase.PersonalDetails;

public interface service {
    void candidateDetail(String name , String email);
    void candidateSkills(String skills);
    void candidateExperience(String job_title,String company_name, double months_of_experience);
    void candidateEducation(String degree_name);

     //void jobRequirementDetails(String jobTitle , String skills, int experience);
}

