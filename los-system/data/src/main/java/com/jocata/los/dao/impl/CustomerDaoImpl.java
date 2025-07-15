package com.jocata.los.dao.impl;

import com.jocata.los.dao.CustomersDao;
import com.jocata.los.entity.Customers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomersDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customers addCustomer(Customers entity) {

        entityManager.persist(entity);

        return entity;
    }


}
