package com.example.alumni.utils;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.Organisation;
import com.example.alumni.bean.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            Transaction transaction = session.beginTransaction();
//            Organisation org = new Organisation();
//            org.setName("SAP Labs");
//            org.setAddress("Bangalore");
//            session.save(org);
//            transaction.commit();
//            session.close();
//        } finally {
//            session.close();
//        }
//    }
}