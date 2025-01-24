package com.example.demo.ResumeHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service;

@Service
public class ResumeDataExtraction {
    @Autowired 
    service s;
    public void dataExtraction(String resume){
        String skill = skillExtraction(resume);
        s.candidateSkills(skill);
       System.out.println(skill);
    }

    public String skillExtraction(String text){
        //StringBuilder skills = new StringBuilder();
        Set<String> skills = new TreeSet<>();
        Pattern pattern = Pattern.compile("\\b(java|springboot|mysql|hibernate|python|dart|c\\+\\+|c|oracle|firebase|git|github|docker|jdbc)\\b");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            skills.add(matcher.group());
        }
        return String.join(", ", skills);
    }
/* 
    public String companyExtraction(String text){
        StringBuilder company_name = new StringBuilder();
        Pattern pattern = Pattern.compile("[A-Za-z ]+\s(Ltd|Inc|Corporation|LLC|Pvt Ltd|GmbH)");
    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            company_name.append(matcher.group()).append(" ");
        }
        return company_name.toString();
    }

    
    public String jobTitleExtraction(String text){
        StringBuilder jobTitle = new StringBuilder();
        Pattern pattern = Pattern.compile("(Intern|Software Engineer|Developer|Lead|Manager|Engineer)\\s*");
    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            jobTitle.append(matcher.group()).append(" ");
        }
        return jobTitle.toString();
    }

  
    public String yearsExtraction(String text){
        StringBuilder years = new StringBuilder();
        Pattern pattern = Pattern.compile("(Intern|Software Engineer|Developer|Lead|Manager|Engineer)\\s*");
    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            years.append(matcher.group()).append(" ");
        }
        return jobTitle.toString();
    }*/

}
