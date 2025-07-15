package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.CarTypesDao;
import com.jocata.warranty_system.entity.CarTypes;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarTypesDaoImpl implements CarTypesDao {
    @Override
    public CarTypes addCarType(CarTypes entity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CarTypes updatCarType(CarTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarTypes res = session.merge(entity);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public CarTypes getCarType(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarTypes entity =session.get(CarTypes.class,id);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public List<CarTypes> getAllCarType() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<CarTypes> entity = session.createQuery("FROM CarTypes",CarTypes.class).getResultList();
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public String deleteCarType(CarTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Record Deleted Successfully";
    }
}
