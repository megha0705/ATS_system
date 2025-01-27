package com.example.demo.ResumeHandling;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class EducationExtraction {
    //EXTRACTING EDUCATION DEGREE
      public static String educationDegreeExtraction(String text){

        Set<String> eduDegree = new TreeSet<>();

        Pattern pattern = Pattern.compile("\\b(diploma|bachelor of technology|information technology|computer science|computer application)\\b");
        Matcher matcher  = pattern.matcher(text);

        while(matcher.find()){
            eduDegree.add(matcher.group());
        }
        
        return String.join(", ", eduDegree);
    }
}
