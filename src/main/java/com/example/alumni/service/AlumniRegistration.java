package com.example.alumni.service;

import com.example.alumni.bean.AlumniDetails;
import static com.example.alumni.dao.PInfoDAO.hasregistered;
import static com.example.alumni.dao.PInfoDAO.insertAlumniDetails;

public class AlumniRegistration {

    public static int insert_pinfo(AlumniDetails alumni){
        System.out.println("Service Layer hit");
        int returnvalue=hasregistered(alumni);
        System.out.println(returnvalue);
        if(returnvalue==1){
            insertAlumniDetails(alumni);
            return 1;
        }
        else
            return -1;
    }
}
