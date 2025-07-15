package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.CustomerDao;
import com.jocata.warranty_system.entity.CarModels;
import com.jocata.warranty_system.entity.Customers;
import com.jocata.warranty_system.form.CustomerResForm;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    public Customers createCustomer(Customers entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

         session.persist(entity);

        tx.commit();
        session.close();
        return entity;
    }


    @Override
    public Customers updateCustomer(Customers entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customers mergedEntity = (Customers) session.merge(entity);
        tx.commit();
        session.close();

        return mergedEntity;
    }

    public Customers getCustomer(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customers customers = session.find(Customers.class, id);
        tx.commit();
        session.close();

        return customers;

    }

    public List<Customers> getAllCustomer(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Customers> customers = session.createQuery("FROM Customers",Customers.class).getResultList();
        tx.commit();
        session.close();
        return customers;
    }

    public String deleteCustomer(Customers entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Customer Deleted Successfully";
    }
}
