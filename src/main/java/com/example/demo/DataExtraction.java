package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DataExtraction {
      @Autowired
    service s;
    public void headerExtract(String contentHandler){
        
        String str1 [] =  contentHandler.toLowerCase().split("\n");
        ExtractedDataEntity ed = new ExtractedDataEntity();
        for(int i =0; i < str1.length; i++){
            
            if(str1[i].trim().equals("skills")){
                int j = i;
                StringBuilder skill = new StringBuilder();
                while(j < str1.length && !(str1[j].trim().equals("experience")) && !(str1[j].trim().equals("projects")) && !(str1[j].trim().equals("education")) &&  !(str1[j].trim().equals("certification")) ){
                    skill.append(str1[j]).append("\n");
                    j++;
                }
                ed.setSkill(skill.toString());
            
            }else if(str1[i].trim().equals("experience")){
                int j = i;
                StringBuilder experience = new StringBuilder();
                while(j < str1.length && !(str1[j].trim().equals("skills")) && !(str1[j].trim().equals("projects")) &&!(str1[j].trim().equals("certifications")) && !(str1[j].trim().equals("education")) ){
                    experience.append(str1[j]).append("\n");
                    j++;
                }
                ed.setExperience(experience.toString());
                
            }else if(str1[i].trim().equals("projects")){
                int j = i;
                StringBuilder projects = new StringBuilder();
                while(j < str1.length && !(str1[j].trim().equals("skills")) && !(str1[j].trim().equals("experience")) && !(str1[j].trim().equals("certifications")) && !(str1[j].trim().equals("education")) ){
                    projects.append(str1[j]).append("\n");
                    j++;
                }
                ed.setProjects(projects.toString());
                break;
            }
        }

        if(s != null){
            s.ExtractedDataResume(ed.getSkill() , ed.getExperience(), ed.getProject());

        }else{
            System.out.println("The object 's' is null.");
        }
       System.out.println(ed.getSkill() + ed.getExperience()+ ed.getProject());
    }
    
}
