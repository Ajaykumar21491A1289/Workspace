package com.jocata.los.dao.impl;

import com.jocata.los.dao.AddressDao;
import com.jocata.los.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address addAddress(Address entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }
}
