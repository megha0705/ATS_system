package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controller {
    @Autowired

    service s;
    @PostMapping("ats")
    public String atsSystem(@RequestParam String name , @RequestParam String email, @RequestParam MultipartFile file) throws Exception{
        s.candidateDetail(name, email);
        PdfHandler pdf = new PdfHandler();
       String str =  pdf.saveResume(file);

        return "saved successfully" +  str ;
    }
}
