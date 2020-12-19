package com.example.alumni.service;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.bean.AlumniOrganisation;
import com.example.alumni.dao.EInfoDAO;
import com.example.alumni.dao.PInfoDAO;

import java.util.List;

import static com.example.alumni.dao.PInfoDAO.*;

import static com.example.alumni.dao.PInfoDAO.insertAlumniDetails;
import  static  com.example.alumni.dao.EInfoDAO.insertAlumniEducationDetails;
import static com.example.alumni.dao.EInfoDAO.*;
import static com.example.alumni.dao.OInfoDAO.insertAlumniOrganisationDetails;
public class AlumniRegistration {

    public static int insert_pinfo(AlumniDetails alumni){
        System.out.println("Service Layer hit");
        int returnvalue= PInfoDAO.hasregistered(alumni);
        System.out.println(returnvalue);
        if(returnvalue==1){
            insertAlumniDetails(alumni);
            return 1;
        }
        else
            return -1;
    }

    public  static int insert_einfo(List<AlumniEducation> edetails){

        insertAlumniEducationDetails(edetails);
        return  1;

    }

    public static int insert_oinfo(List<AlumniOrganisation> odetails){

            insertAlumniOrganisationDetails(odetails);
            return  1;

    }
}
