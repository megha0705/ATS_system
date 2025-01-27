package com.example.demo.CandidateDatabase;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education_details_of_candidate")
public class CandidateEducation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int edu_id;
  @OneToOne
  @JoinColumn(name = "candidate_id", unique = true) 
  private PersonalDetails candidate_id;
  private String degree_name;
   
}
