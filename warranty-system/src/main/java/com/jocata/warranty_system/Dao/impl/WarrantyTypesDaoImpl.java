package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.WarrantyTypesDao;
import com.jocata.warranty_system.entity.WarrantyTypes;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarrantyTypesDaoImpl implements WarrantyTypesDao {
    @Override
    public WarrantyTypes addWarrantyType(WarrantyTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public WarrantyTypes updateWarrantyTypes(WarrantyTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyTypes type = session.merge(entity);
        session.flush();
        session.refresh(type);
        tx.commit();
        session.close();
        return type;
    }

    @Override
    public WarrantyTypes getWarrantyTypes(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        WarrantyTypes entity = session.get(WarrantyTypes.class,id);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public List<WarrantyTypes> getAllWarrantyTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<WarrantyTypes> entity = session.createQuery("FROM WarrantyTypes",WarrantyTypes.class).getResultList();
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public String deleteWarrantyTypes(WarrantyTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Entity Deleted Successfully";
    }


}
