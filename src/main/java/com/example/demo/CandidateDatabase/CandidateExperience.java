package com.example.demo.CandidateDatabase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "candidate_experience_details")
public class CandidateExperience {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int exp_id;
    @OneToOne
    @JoinColumn(name = "candidate_id", unique = true) 
    private PersonalDetails candidate_id;
    private String job_title;
    private String company_name;
    private int years_of_experience;
}
