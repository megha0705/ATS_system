package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DataExtraction {
      @Autowired
      service s;
    public void headerExtract(String contentHandler){
        
        String str1 [] =  contentHandler.toLowerCase().split("\n");
        StringBuilder skill = new StringBuilder();
        StringBuilder experience = new StringBuilder();
        StringBuilder projects = new StringBuilder();

       //ExtractedDataEntity ed = new ExtractedDataEntity();
        for(int i =0; i < str1.length; i++){
            
            if(str1[i].trim().equals("skills")){
                int j = i;
              
                while(j < str1.length && !(str1[j].trim().equals("experience")) && !(str1[j].trim().equals("projects")) && !(str1[j].trim().equals("education")) &&  !(str1[j].trim().equals("certification")) ){
                    skill.append(str1[j]).append("\n");
                    j++;
                }
                
            
            }else if(str1[i].trim().equals("experience")){
                int j = i;
                
                while(j < str1.length && !(str1[j].trim().equals("skills")) && !(str1[j].trim().equals("projects")) &&!(str1[j].trim().equals("certifications")) && !(str1[j].trim().equals("education")) ){
                    experience.append(str1[j]).append("\n");
                    j++;
                }
              
                
            }else if(str1[i].trim().equals("projects")){
                int j = i;
                while(j < str1.length && !(str1[j].trim().equals("skills")) && !(str1[j].trim().equals("experience")) && !(str1[j].trim().equals("certifications")) && !(str1[j].trim().equals("education")) ){
                    projects.append(str1[j]).append("\n");
                    j++;
                }
            
                break;
            }
        }

        if(s != null){
            s.ExtractedDataResume(skill.toString(), experience.toString(), projects.toString());

        }else{
            s.ExtractedDataResume(skill.toString(), experience.toString(), projects.toString());

            System.out.println("The object 's' is null.");
        }
      //  s.ExtractedDataResume(skill.toString(), experience.toString(), projects.toString());
      // System.out.println(ed.getSkill() + ed.getExperience()+ ed.getProject());
    }
    
}
