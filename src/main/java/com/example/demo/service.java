package com.example.demo;

import java.util.ArrayList;
import java.util.*;
public interface service {
    void candidateDetail(String name , String email);
    void candidateSkills(ArrayList<String> skills);
    void candidateExperience(String job_title,String company_name, double months_of_experience);
    void candidateEducation(ArrayList<String> degree_name);
    List<String> jobRequirementDetails(String jobTitle , String skills, int experience, String degree);
     
}

