package com.example.demo.ResumeHandling;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
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

       String company_name = companyExtraction(resume);
       System.out.println(company_name);

       String job_title = jobTitleExtraction(resume);
       System.out.println(job_title);

       double years = yearsExtraction(resume);
       System.out.println(years);
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
 
    public String companyExtraction(String text){
        Set<String> company_name = new TreeSet<>();
        Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+)\\s?(Ltd|Inc|Corporation|LLC|Pvt\\sLtd|GmbH|Limited|Group)\\b", Pattern.CASE_INSENSITIVE);
    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            company_name.add(matcher.group());

            }
            
            
        
        return String.join(", ", company_name);
    }

    
    public String jobTitleExtraction(String text){
        Set<String> jobTitle = new TreeSet<>();
        Pattern pattern = Pattern.compile("\\b(intern|software\\sengineer|developer|lead|manager)\\b");

    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            jobTitle.add(matcher.group());
        }
        return String.join(", ", jobTitle);
    }

    public double yearsExtraction(String text){
        Set<String> years = new TreeSet<>();
        Pattern pattern = Pattern.compile("(\\w+ \\d{4})\\s*–\\s*(\\w+ \\d{4})");
    
        Matcher matcher = pattern.matcher(text);
        double inYears = 0;
        while(matcher.find()){
            String startDate = matcher.group(1).toUpperCase();
            String endDate = matcher.group(2).toUpperCase();
            //this is will convert it to a localDate object
            DateTimeFormatter formatted = DateTimeFormatter.ofPattern("MMM yyyy");
            //this is will convert the date to the localdate object jun 2024 to 2024-05-
             YearMonth startDateformatted =  YearMonth.parse(startDate,formatted);
             YearMonth endDateFormatted =  YearMonth.parse(endDate  ,formatted);
            long monthsDifference = java.time.temporal.ChronoUnit.MONTHS.between(startDateformatted, endDateFormatted);
            double experience = monthsDifference/12.0;
            inYears += experience;

        }
        return inYears;
    }

}
