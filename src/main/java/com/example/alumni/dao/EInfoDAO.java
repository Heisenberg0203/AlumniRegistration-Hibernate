package com.example.alumni.dao;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EInfoDAO {

    public static  void insertAlumniEducationDetails(List<AlumniEducation> edetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        for(AlumniEducation edetail:edetails){
            edetail.setAlumni(session.get(AlumniDetails.class,edetail.getAlumni().getId()));
            session.save(edetail);
        }


        transaction.commit();
        session.close();
    }
}
