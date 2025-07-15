package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.CarSaleRecordsDao;
import com.jocata.warranty_system.entity.CarSaleRecords;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Remove;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarSaleRecordsDaoImpl implements CarSaleRecordsDao {
    @Override
    public CarSaleRecords addCarSaleRecords(CarSaleRecords entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public CarSaleRecords updateCarSaleRecords(CarSaleRecords entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       CarSaleRecords res =  session.merge(entity);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public CarSaleRecords getCarSaleRecords(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarSaleRecords res =  session.get(CarSaleRecords.class,id);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public List<CarSaleRecords> getAllCarSaleRecords() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<CarSaleRecords> res =  session.createQuery("FROM CarSaleRecords",CarSaleRecords.class).getResultList();
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public String deleteCarSaleRecords(CarSaleRecords entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Entity Deleted Successfully";
    }
}
