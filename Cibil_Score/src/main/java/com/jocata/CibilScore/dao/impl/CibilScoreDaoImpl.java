package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.CibilScoreDao;
import com.jocata.CibilScore.entity.CibilScore;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CibilScoreDaoImpl implements CibilScoreDao {
    @Override
    public CibilScore saveCibilScore(CibilScore cibilScore) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(cibilScore);
        tx.commit();
        session.close();
        return cibilScore;
    }
}
