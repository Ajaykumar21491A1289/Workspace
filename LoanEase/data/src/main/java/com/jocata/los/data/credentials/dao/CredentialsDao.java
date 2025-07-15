package com.jocata.los.data.credentials.dao;

import com.jocata.los.datamodel.auth.entity.Credentials;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsDao {

    Credentials addCredentials(Credentials credentials);
    Credentials getCredentials(String userName);

}
