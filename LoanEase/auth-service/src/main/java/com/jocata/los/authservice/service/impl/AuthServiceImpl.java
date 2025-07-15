package com.jocata.los.authservice.service.impl;

import com.jocata.los.authservice.config.JwtUtil;
import com.jocata.los.authservice.service.AuthService;

import com.jocata.los.data.credentials.dao.CredentialsDao;
import com.jocata.los.datamodel.auth.entity.Credentials;
import com.jocata.los.datamodel.auth.form.AuthRequest;
import com.jocata.los.datamodel.auth.form.AuthResponse;
import com.jocata.los.datamodel.user.form.UserProfile;
import com.jocata.los.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserService userService;

    @Autowired
    CredentialsDao credentialsDao;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    @Transactional
    public ResponseEntity<?> register(UserProfile userProfile) {

        if (credentialsDao.getCredentials(userProfile.getUserName()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        Credentials entity = new Credentials();
        entity.setUserName(userProfile.getUserName());
        entity.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        entity.setRole(userProfile.getRole());
        credentialsDao.addCredentials(entity);
        userService.setUserService(userProfile);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
    }

    @Override
    public String validateUser(AuthRequest request) {
        Credentials credential = credentialsDao.getCredentials(request.getUsername());

        if (credential != null) {
            // Use PasswordEncoder to match raw password with encoded one
            boolean isMatch = passwordEncoder.matches(request.getPassword(), credential.getPassword());
            if (isMatch) {
                return credential.getRole(); // return role if authentication is successful
            }
        }

        return null; // user not found or password doesn't match
    }



}
