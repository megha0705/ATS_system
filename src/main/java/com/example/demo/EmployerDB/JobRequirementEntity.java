package com.example.demo.EmployerDB;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Table(name = "Job_requirement")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobRequirementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "job_title")
    private String jobTitle;
    private String skill;
    private int experience_inMonths;
    private String degree;
}
