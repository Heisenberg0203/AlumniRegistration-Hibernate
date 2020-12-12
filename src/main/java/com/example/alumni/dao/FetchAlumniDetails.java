package com.example.alumni.dao;

import com.example.alumni.bean.Student;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FetchAlumniDetails {

    public static List<Student> getAlumni(Student student){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from Student where fname like '%"+student.getFname()+"%'" +
                " and lname like '%"+student.getLname()+"%'" +
                " and year="+student.getYear());
        List<Student> alumnilist= fetchquery.list();
        transaction.commit();
        session.close();
        return alumnilist;
    }
}
