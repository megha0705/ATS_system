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
        s.candidateExperience(job_title, company_name, years);
       String eduDegree = educationDegreeExtraction(resume);
       System.out.println(eduDegree);

     //  String eduInstitute = eduInstituteExtraction(resume);
       //System.out.println(eduInstitute);

     //  String eduYears = educationYearExtraction(resume);
       //System.out.println(eduYears);
    }



    //  EXTRACTING SKILLS
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
     


    //EXTRACTIING COMPANY NAME
    public String companyExtraction(String text){
        Set<String> company_name = new TreeSet<>();
        Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+)\\s?(Ltd|Inc|Corporation|LLC|Pvt\\sLtd|GmbH|Limited|Group)\\b", Pattern.CASE_INSENSITIVE);
    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            company_name.add(matcher.group());

            }
            
            
        
        return String.join(", ", company_name);
    }

    

    //EXTARCTING JOB TITLE
    public String jobTitleExtraction(String text){
        Set<String> jobTitle = new TreeSet<>();
        Pattern pattern = Pattern.compile("\\b(intern|software\\sengineer|developer|lead|manager)\\b");

    
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            jobTitle.add(matcher.group());
        }
        return String.join(", ", jobTitle);
    }



    //EXTARCTING YEARS OF EXPERIENCE
    public double yearsExtraction(String text){
        
        Pattern pattern = Pattern.compile("(\\w+ \\d{4})\\s*–\\s*(\\w+ \\d{4})");
    
        Matcher matcher = pattern.matcher(text);
        double inYears = 0;
        while(matcher.find()){
            String startDate = matcher.group(1).toUpperCase();
            String endDate = matcher.group(2).toUpperCase();
           
            String startingDate [] = startDate.split(" ");
            String endingDate [] = endDate.split(" ");

            String month1 = startingDate[0];
            String year1 = startingDate[1];

            String month2 = endingDate[0];
            String year2 = endingDate[1];

            MonthNumber getNumber = new MonthNumber();

            String monthNumber1 = getNumber.getMonthNumber(month1);
            String monthNumber2 = getNumber.getMonthNumber(month2);

            String finalStartDate = monthNumber1 + " " + year1;
            String finalendDate = monthNumber2 + " " + year2;


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM yyyy");

            YearMonth startingDateFormatted = YearMonth.parse(finalStartDate, formatter);
            YearMonth endDateFormatted = YearMonth.parse(finalendDate, formatter);

            long monthsDifference = java.time.temporal.ChronoUnit.MONTHS.between(startingDateFormatted, endDateFormatted);
            double experience = monthsDifference;
            inYears += experience;

        }
        return inYears;
    }

    public String educationDegreeExtraction(String text){
        Set<String> eduDegree = new TreeSet<>();
        Pattern pattern = Pattern.compile("\\b(diploma|bachelor of technology|information technology|computer science|computer application)\\b");
        Matcher matcher  = pattern.matcher(text);
        while(matcher.find()){
            eduDegree.add(matcher.group());
        }
        return String.join(", ", eduDegree);
    }
 


/* 
    public String educationYearExtraction(String text){
        Set<String> eduYears = new TreeSet<>();
        Pattern pattern = Pattern.compile("(?i)\\b(?:bachelor|master|diploma|degree|university|college|institute|institution|school)\\b[^\\d]*(19\\d{2}|20\\d{2})\\b");
        Matcher matcher  = pattern.matcher(text);
        while(matcher.find()){
            eduYears.add(matcher.group());
        }
        return String.join(", ", eduYears);
    }
    //this is keep etxracting other stuffs from the resume

    /*public String eduInstituteExtraction(String text){
        Set<String> eduInstitute = new TreeSet<>();
      //  Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+)\\s?(university|college|institution|academy)\\b");
     //      Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+)\\b\\s?(university|college|academy|institute)", Pattern.CASE_INSENSITIVE);
     //   Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+)(?=\\s(university|academy|institute))", Pattern.CASE_INSENSITIVE);
     Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+?)\\s+(university|institute|academy)\\b", Pattern.CASE_INSENSITIVE);

    // Pattern pattern = Pattern.compile("\\b([A-Za-z0-9&'\"\\-\\s]+?)\\s+(university|college|institute|academy)", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            eduInstitute.add(matcher.group());
        }
        return String.join(", ", eduInstitute);
    }*/



}
