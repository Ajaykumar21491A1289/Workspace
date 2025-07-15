package com.jocata.los.data.user.dao.impl;

import com.jocata.los.data.user.dao.UserDAO;
import com.jocata.los.datamodel.user.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
        entityManager.refresh(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> getAllUsers() {
        String query="select u from User u";
        return entityManager.createQuery(query,User.class).getResultList();

    }

    @Override
    public User updateUser(User updatedUser) {
        return entityManager.merge(updatedUser);
    }

    @Override
    public String deleteUser(User user) {
        entityManager.remove(user);
        return "user deleted successfully";
    }
}
