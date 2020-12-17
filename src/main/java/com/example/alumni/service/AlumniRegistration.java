package com.example.alumni.service;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.bean.AlumniOrganisation;

import java.util.List;

import static com.example.alumni.dao.PInfoDAO.hasregistered;
import static com.example.alumni.dao.PInfoDAO.insertAlumniDetails;
import  static  com.example.alumni.dao.EInfoDAO.insertAlumniEducationDetails;
import static com.example.alumni.dao.OInfoDAO.insertAlumniOrganisationDetails;
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

    public  static int insert_einfo(List<AlumniEducation> edetails){
        if(edetails.get(0).getAlumni()==null){
            //incorrect entry to page
            return  -1;
        }
        else{
            insertAlumniEducationDetails(edetails);
            return  1;
        }
    }

    public static int insert_oinfo(List<AlumniOrganisation> odetails){
        if(odetails.get(0).getAlumni()==null){
            //incorrect entry to page
            return  -1;
        }
        else{
            insertAlumniOrganisationDetails(odetails);
            return  1;
        }
    }
}
