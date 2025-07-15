package com.jocata.los.dao.impl;

import com.jocata.los.dao.LoanDetailsDao;
import com.jocata.los.entity.LoanApplications;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoanDetailsDaoImpl implements LoanDetailsDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public LoanApplications addLoan(LoanApplications entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public LoanApplications getLoan(Integer loanId) {
        return entityManager.find(LoanApplications.class,loanId);
    }
}
