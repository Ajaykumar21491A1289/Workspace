package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.CustomerDao;
import com.jocata.CibilScore.entity.Customer;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer saveCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(customer);
        tx.commit();
        session.close();
        return customer;
    }

    @Override
    public Customer findByPan(String pan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql ="From Customer C where c.pan=:pan";
        Customer customer = session.createQuery(hql,Customer.class).setParameter("Pan",pan).uniqueResult();
        tx.commit();
        session.close();
        return customer;

    }

}
