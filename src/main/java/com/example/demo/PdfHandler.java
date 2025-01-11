package com.example.demo;
import java.io.*;
import java.util.HashMap;

import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
//import org.hibernate.boot.Metadata;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;


public class PdfHandler {
    public String saveResume(MultipartFile file) throws Exception{
        String directory =  "C:/Users/Reshmi Chakraborty/Desktop/coding/projects/ATS_system/CandidateResume";
        File file1 = new File(directory);
        if(!file1.exists()){
            file1.mkdirs();
        }
        File file2 = new File(directory, file.getOriginalFilename());
        try{
            file.transferTo(file2);
        }catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String fileNewDirectory = directory + "/"+ file.getOriginalFilename();
        pdfExtraction(fileNewDirectory);
        return "file is saved successfully";
    }
    
    public void pdfExtraction(String file) throws Exception{
       
       // Create a content handler
       //it basically creates a bucket to hold the extracted data
       BodyContentHandler contenthandler
       = new BodyContentHandler();

   // Create a file in local directory
  

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
       // String author = data.get(Metadata.MESSAGE_RAW_HEADER_PREFIX);
   // Method parse invoked on PDFParser class
   //it opens the file and stores teh data from pdf to contenthandler and  extract meta data store in data , 
   //context tells the parser if there are any special instructions or tools to use while reading
   pdfparser.parse(fstream, contenthandler, data,
                   context);

   // Printing the contents of the pdf document
   // using toString() method in java
  /*System.out.println("Extracting contents :"+
                       contenthandler.toString());*/

String line = contenthandler.toString();

String str1 [] =  line.toLowerCase().split("\n");
HashMap <String , String> sectionHeader = new HashMap<>();
for(int i =0; i < str1.length; i++){
    System.out.println(str1[i] );
}


    }
}
