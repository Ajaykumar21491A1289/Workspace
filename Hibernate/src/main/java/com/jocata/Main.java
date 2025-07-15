package com.jocata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        pojo.setName("Ajay kumar");
        pojo.setSid(1);

        // Hibernate configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); // Make sure this file is in your classpath
        config.addAnnotatedClass(com.jocata.Pojo.class);  // Add your Pojo class to the config
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(pojo);
        Pojo p = session.find(Pojo.class,1); // eager
        Pojo p1 = session.byId(Pojo.class).getReference(1);//lazy fetching
        System.out.println(p);
        System.out.println(p1);

        //update a data
        session.merge(pojo);
        Pojo p2 = session.find(Pojo.class,1);
        System.out.println(p2);


        //how to delete the data
        session.remove(p2);
        transaction.commit();
    }
}
