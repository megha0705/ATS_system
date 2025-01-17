package com.example.demo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Job_criteria_table")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CriteriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "job_title")
    private String jobTitle;
    private String skill;
    private int experience;
   

}
