package com.example.demo.CandidateDatabase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_skills")
public class CandidateSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skill_id;
    
    @ManyToOne
    private  PersonalDetails candidateId;
    @Column(length =  500)
    private String skillName;
}
