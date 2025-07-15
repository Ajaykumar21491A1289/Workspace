package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.WarrantyPlansDao;
import com.jocata.warranty_system.entity.WarrantyPlans;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarrantyPlansDaoImpl implements WarrantyPlansDao {
    @Override
    public WarrantyPlans addWarrantyPlans(WarrantyPlans entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public WarrantyPlans updateWarrantyPlans(WarrantyPlans entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyPlans res = session.merge(entity);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public WarrantyPlans getWarrantyPlans(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyPlans res = session.get(WarrantyPlans.class,id);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public List<WarrantyPlans> getALlWarrantyPlans() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<WarrantyPlans> res = session.createQuery("FROM WarrantyPlans",WarrantyPlans.class).getResultList();
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public String deleteWarrantyPlans(WarrantyPlans entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Entity Deleted Successfully";
    }
}
