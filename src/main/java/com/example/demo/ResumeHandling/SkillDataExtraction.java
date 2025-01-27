package com.example.demo.ResumeHandling;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class SkillDataExtraction {

        //  EXTRACTING SKILLS

    public static String skillExtraction(String text){
        
        Set<String> skills = new TreeSet<>();

        Pattern pattern = Pattern.compile("\\b(java|springboot|mysql|hibernate|python|dart|c\\+\\+|c|oracle|firebase|git|github|docker|jdbc)\\b");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            skills.add(matcher.group());
        }

        return String.join(", ", skills);
    }
}
