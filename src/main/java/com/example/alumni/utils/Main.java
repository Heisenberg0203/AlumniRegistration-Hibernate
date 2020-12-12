package com.example.alumni.utils;

import com.example.alumni.bean.AlumniDetails;
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
//            AlumniDetails alumni = new AlumniDetails();
//            alumni.setEmail("rushikesh0203@gmail.com");
//            alumni.setContact("8624982994");
//            Student s1 = new Student();
//            s1 = (Student) session.get(Student.class,1);
//            alumni.setStudent(s1);
//            session.save(alumni);
//            transaction.commit();
//            session.close();
//        } finally {
//            session.close();
//        }
//    }
}