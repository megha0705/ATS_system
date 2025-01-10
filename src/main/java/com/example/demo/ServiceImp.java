package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp implements service {
       @Autowired
    CandidateRepo repo;

    public void candidateDetail(String name , String email){
            CandidateEntity entity = new CandidateEntity();
            entity.setEmailAddress(email);
            entity.setFullName(name);
            repo.save(entity);
           
    }
}
