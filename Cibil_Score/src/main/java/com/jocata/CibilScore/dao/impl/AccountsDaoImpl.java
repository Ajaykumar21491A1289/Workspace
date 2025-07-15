package com.jocata.CibilScore.dao.impl;

import com.jocata.CibilScore.dao.AccountsDao;
import com.jocata.CibilScore.entity.Accounts;
import com.jocata.CibilScore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsDaoImpl implements AccountsDao {
    @Override
    public Accounts saveAccount(Accounts account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(account);
        tx.commit();
        session.close();
        return account;
    }
}
