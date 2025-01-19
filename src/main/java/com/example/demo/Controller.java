package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {

    @Autowired
    service s;
    
    @Autowired
    PdfHandler pdf;

    @PostMapping("ats")
    public RedirectView atsSystem(@RequestParam String name , @RequestParam String email, @RequestParam MultipartFile file) throws Exception{
        s.candidateDetail(name, email);
        pdf.saveResume(file) ;
        return new RedirectView("/jobRequirementForm.html");
     
    }
    @PostMapping("submitJobRequirement")
    public String submitRequirementForm(@RequestParam String jobTitle , @RequestParam String skills, @RequestParam int experience ){
        s.jobRequirementDetails(jobTitle, skills, experience);
        
        return "data submitted succesfully";

    }
    
}
