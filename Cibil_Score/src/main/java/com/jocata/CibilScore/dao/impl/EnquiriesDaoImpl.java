package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.EnquiriesDao;
import com.jocata.CibilScore.entity.Enquiries;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class EnquiriesDaoImpl implements EnquiriesDao {
    @Override
    public Enquiries saveEnquiry(Enquiries enquiry) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(enquiry);
        tx.commit();
        session.close();
        return enquiry;
    }
}
