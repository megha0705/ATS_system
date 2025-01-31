package com.example.demo.CandidateDatabase;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_details_of_candidates")
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int candidate_id;
    private String candidate_name;
    private String candidate_email;
    @OneToMany(mappedBy = "candidateId", cascade = CascadeType.ALL)
    private List<CandidateSkills> candidateSkills;

}
