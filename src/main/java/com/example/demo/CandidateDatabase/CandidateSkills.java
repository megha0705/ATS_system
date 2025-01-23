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
    @OneToOne
    @JoinColumn(name = "candidate_id", unique = true) 
    private  PersonalDetails candidate_id;
    private String skill_name;
}
