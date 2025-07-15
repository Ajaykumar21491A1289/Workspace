package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.RemarksDao;
import com.jocata.CibilScore.entity.Remarks;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository
public class RemarksDaoImpl implements RemarksDao {
    @Override
    public Remarks saveRemark(Remarks remark) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(remark);
        tx.commit();
        session.close();
        return remark;
    }
}
