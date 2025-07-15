package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.CoverageTypeDao;
import com.jocata.warranty_system.entity.CoverageTypes;
import com.jocata.warranty_system.form.CoverageTypeReqForm;
import com.jocata.warranty_system.form.CoverageTypeResForm;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class CoverageTypeDaoImpl implements CoverageTypeDao {
    @Override
    public CoverageTypes addCoverareType(CoverageTypes entity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    public CoverageTypes updateCoverageType(CoverageTypes entity){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CoverageTypes res = session.merge(entity);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public CoverageTypes getCoverageTypes(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CoverageTypes res = session.get(CoverageTypes.class,id);
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public List<CoverageTypes> getAllCoverageTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<CoverageTypes> res= session.createQuery("FROM CoverageTypes",CoverageTypes.class).getResultList();
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public String deleteCoverageType(CoverageTypes entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Entity Deleted Successfully";
    }

}
