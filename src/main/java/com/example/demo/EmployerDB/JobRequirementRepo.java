package com.example.demo.EmployerDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRequirementRepo extends JpaRepository<JobRequirementEntity, Integer> {

     
}