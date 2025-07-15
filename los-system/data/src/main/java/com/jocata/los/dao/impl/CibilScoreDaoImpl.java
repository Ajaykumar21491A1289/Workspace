package com.jocata.los.dao.impl;

import com.jocata.los.dao.CibilScoreDao;
import com.jocata.los.entity.CibilScoreDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CibilScoreDaoImpl implements CibilScoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CibilScoreDetails addCibilScore(CibilScoreDetails entity) {

        entityManager.persist(entity);

        return entity;
    }
}
