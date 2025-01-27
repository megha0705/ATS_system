package com.example.demo.ResumeHandling;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class ExperienceDataExtraction {

       //EXTRACTING COMPANY NAME 


       public static String companyExtraction(String text){

            Set<String> company_name = new TreeSet<>();

            Pattern pattern = Pattern.compile( "(?<=\\n)[A-Za-z\\s]+(?:Ltd|Inc|Corp|LLC|Pvt\\sLtd|GmbH|Limited|Group)",Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            while(matcher.find()){
                company_name.add(matcher.group());
                }
                
            return String.join(", ", company_name);
        }



     //EXTARCTING JOB TITLE

    
     public static String jobTitleExtraction(String text){

        Set<String> jobTitle = new TreeSet<>();

        Pattern pattern = Pattern.compile("\\b(intern|software\\sengineer|developer|lead|manager)\\b");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            jobTitle.add(matcher.group());
        }

        return String.join(", ", jobTitle);
    }
    



    
    //EXTARCTING YEARS OF 
    
    
    public static double yearsExtraction(String text){
        
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

}
