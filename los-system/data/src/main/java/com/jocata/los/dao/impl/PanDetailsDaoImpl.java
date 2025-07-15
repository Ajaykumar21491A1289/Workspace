package com.jocata.los.dao.impl;

import com.jocata.los.dao.PanDetailsDao;
import com.jocata.los.entity.PanDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PanDetailsDaoImpl implements PanDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public PanDetails addPanDetails(PanDetails entity) {
        entityManager.persist(entity);
        return entity;
    }
}
