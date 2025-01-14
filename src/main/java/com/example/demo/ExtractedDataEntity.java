package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "resume_extracted_data")
public class ExtractedDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "candidate_id", unique = true) 
    private CandidateEntity can_id;
    private String skills;
    private String experience;
    private String project;
    ExtractedDataEntity(){
    }

    public void setSkill(String skills){
        this.skills = skills;
    }
    public String getSkill(){
        return skills;
    }
    public void setExperience(String experience){
        this.experience = experience;
    }
    public String getExperience(){
        return experience;
    }
    public void setProjects(String project){
        this.project = project;
    }
    public String getProject(){
        return project;
    }
}
