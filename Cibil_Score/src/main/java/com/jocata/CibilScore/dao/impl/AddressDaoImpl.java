package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.AddressDao;
import com.jocata.CibilScore.entity.Addresses;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao {
    @Override
    public Addresses saveAddress(Addresses addresses) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(addresses);
        tx.commit();
        session.close();
        return addresses;
    }
}
