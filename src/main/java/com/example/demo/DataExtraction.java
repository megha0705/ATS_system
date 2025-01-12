package com.example.demo;

public class DataExtraction {
    public void headerExtract(String contentHandler){
        String str1 [] =  contentHandler.toLowerCase().split("\n");
        ExtractedData ed = new ExtractedData();
        for(int i =0; i < str1.length; i++){
            
            if(str1[i].trim().equals("skills")){
                int j = i;
                StringBuilder skill = new StringBuilder();
                while(j < str1.length && !str1[j].equals("experience") && !str1[j].equals("projects")){
                    skill.append(str1[j]).append(" ");
                    j++;
                }
                ed.setSkill(skill.toString());
                
            }
        }
       System.out.println(ed.getSkill());
    }
}
