package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.CreditReportsDao;
import com.jocata.CibilScore.entity.CreditReports;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CreditReportDaoImpl implements CreditReportsDao {


    @Override
    public CreditReports saveCreditReport(CreditReports creditReports) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(creditReports);
        tx.commit();
        session.close();
        return creditReports;
    }


    @Override
    public CreditReports findCibilScore(String pan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        String hql = """
        SELECT cr
        FROM CreditReports cr
        JOIN FETCH cr.customer c
        LEFT JOIN FETCH c.addresses a
        LEFT JOIN FETCH cr.cibilScore cs
        LEFT JOIN FETCH cr.accounts acc
        WHERE c.pan = :pan
    """;

        CreditReports creditReport = null;

        try {
            var resultList = session.createQuery(hql, CreditReports.class)
                    .setParameter("pan", pan)
                    .getResultList();

            if (!resultList.isEmpty()) {
                creditReport = resultList.get(0);
                // Initialize lazy collections
                Hibernate.initialize(creditReport.getEnquiries());
                Hibernate.initialize(creditReport.getRemarks());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return creditReport;
    }

}
