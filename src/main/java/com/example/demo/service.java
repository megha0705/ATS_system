package com.example.demo;

import com.example.demo.CandidateDatabase.PersonalDetails;

public interface service {
    void candidateDetail(String name , String email);
    void ExtractedDataResume(String skills, String experience , String projects);
    void jobRequirementDetails(String jobTitle , String skills, int experience);
    void candidateSkills(String skills);
    void candidateExperience(String job_title,String company_name, double months_of_experience);
}

