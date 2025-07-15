package com.jocata.los.dao.impl;


import com.jocata.los.dao.AadharDao;
import com.jocata.los.entity.AadharDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AadharDaoImpl implements AadharDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public AadharDetails addAadhar(AadharDetails entity) {
        entityManager.persist(entity);
        return entity;
    }
}
