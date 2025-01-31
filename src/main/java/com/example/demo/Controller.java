package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.ResumeHandling.ResumeStoring;

@RestController
public class Controller {

    @Autowired
    service s;
    
   // @Autowired
    //PdfHandler pdf;
    @Autowired
    ResumeStoring resume_store;
    @PostMapping("ats")
    public RedirectView atsSystem(@RequestParam String name , @RequestParam String email, @RequestParam MultipartFile file) throws Exception{
        s.candidateDetail(name, email);
        resume_store.saveResume(file) ;
       return  new RedirectView("/formSubmission.html");
     
    }
 
    @PostMapping("submitJobRequirement")
    public List<String> submitRequirementForm(@RequestParam String jobTitle , @RequestParam String skills, @RequestParam int experience, @RequestParam String degree ){
     List<String> candidate_name =   s.jobRequirementDetails(jobTitle, skills, experience,degree);
    //    return new RedirectView("/candidateListing.html");
    return candidate_name;
       

    }
    
}
//RedirectView 
//return new RedirectView("/jobRequirementForm.html");