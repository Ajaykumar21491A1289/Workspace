package com.jocata.los.data.credentials.dao.impl;

import com.jocata.los.data.credentials.dao.CredentialsDao;
import com.jocata.los.datamodel.auth.entity.Credentials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CredentialsDaoImpl implements CredentialsDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Credentials addCredentials(Credentials credentials) {
        entityManager.persist(credentials);
        return credentials;
    }

    @Override
    public Credentials getCredentials(String userName) {
        String query = "SELECT c FROM Credentials c WHERE c.userName = :userName";
        try {
            return entityManager.createQuery(query, Credentials.class)
                    .setParameter("userName", userName)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }



}
