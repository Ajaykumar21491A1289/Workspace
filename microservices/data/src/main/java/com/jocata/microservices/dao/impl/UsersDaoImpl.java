package com.jocata.microservices.dao.impl;

import com.jocata.microservices.dao.UsersDao;
import com.jocata.microservices.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Users registerUser(Users entity) {
        entityManager.persist(entity);
        entityManager.refresh(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public Users findByUsername(String userName) {
        try{
            return entityManager.createQuery("select u from Users u where u.userName=:userName",Users.class)
                    .setParameter("userName",userName)
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
