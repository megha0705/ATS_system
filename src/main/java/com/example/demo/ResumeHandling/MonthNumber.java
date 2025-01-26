package com.example.demo.ResumeHandling;

public class MonthNumber {
    public  String getMonthNumber(String month){
        switch(month){
          case "JAN" : return "01";
          case "FEB" : return "02";
          case "MAR" : return "03";
          case "APR": return "04";
          case "MAY" : return "05";
          case "JUN" : return "06";
          case "JUL" :return "07";
          case "AUG" : return "08";
          case "SEP" : return "09";
          case "OCT" : return "10";
          case "NOV" : return "11";
          case "DEC": return "12";
          default : return "invalid month";
              }
      }
}
