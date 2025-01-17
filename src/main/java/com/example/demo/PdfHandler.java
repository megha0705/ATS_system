package com.example.demo;
import java.io.*;
import java.util.HashMap;

import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.hibernate.boot.Metadata;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@Service
public class PdfHandler {
    @Autowired
    private DataExtraction dataExtract;

    public void saveResume(MultipartFile file) throws Exception{

        String directory =  "C:/Users/Reshmi Chakraborty/Desktop/coding/projects/ATS_system/CandidateResume";

        File file1 = new File(directory);

        if(!file1.exists()){
            file1.mkdirs();
        }

        File file2 = new File(directory, file.getOriginalFilename());

        
        file.transferTo(file2);

        String fileNewDirectory = directory + "/"+ file.getOriginalFilename();

        pdfExtraction(fileNewDirectory);
        
    }
    
    public void pdfExtraction(String file) throws Exception{
       
       // Create a content handler
       //it basically creates a bucket to hold the extracted data
       BodyContentHandler contenthandler
       = new BodyContentHandler();
   
        // Create a file input stream
        // on specified path with the created file
        //opens and real the pdf file
        FileInputStream fstream = new FileInputStream(file);

        //it can be use to extract specific datafrom the file liek author data of creation
        // Create an object of type Metadata to use
        Metadata data = new Metadata();

        // Create a context parser for the pdf document
        ParseContext context = new ParseContext();

        // PDF document can be parsed using the PDFparser
        //it opens the pdf and look at the content inside
        PDFParser pdfparser = new PDFParser();

        
        // Method parse invoked on PDFParser class
        //it opens the file and stores teh data from pdf to contenthandler and  extract meta data store in data , 
        //context tells the parser if there are any special instructions or tools to use while reading
        pdfparser.parse(fstream, contenthandler, data,
                        context);

        dataExtract.headerExtract(contenthandler.toString());

    }
}
