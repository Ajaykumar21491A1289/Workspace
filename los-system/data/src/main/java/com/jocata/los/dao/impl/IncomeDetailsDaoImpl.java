package com.jocata.los.dao.impl;

import com.jocata.los.dao.IncomeDetailsDao;
import com.jocata.los.entity.IncomeDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class IncomeDetailsDaoImpl implements IncomeDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public IncomeDetails addIncomeDetails(IncomeDetails entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }
}
