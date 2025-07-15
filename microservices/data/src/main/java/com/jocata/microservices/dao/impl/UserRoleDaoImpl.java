package com.jocata.microservices.dao.impl;

import com.jocata.microservices.dao.UserRoleDao;
import com.jocata.microservices.entity.UserRoles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRoleDaoImpl implements UserRoleDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public UserRoles addUserRole(UserRoles entity) {
    entityManager.persist(entity);
    return entity;
    }
}
