package com.jocata.los.data.loanapplication.dao.impl;

import com.jocata.los.data.loanapplication.dao.LoanApplicationDao;
import com.jocata.los.datamodel.loanapplication.entity.LoanApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LoanApplicationDaoImpl implements LoanApplicationDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public LoanApplication saveApplication(LoanApplication application) {

        entityManager.persist(application);
        return application;

    }
}
