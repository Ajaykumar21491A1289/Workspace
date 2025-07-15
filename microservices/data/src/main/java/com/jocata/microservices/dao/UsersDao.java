package com.jocata.microservices.dao;

import com.jocata.microservices.entity.Users;

public interface UsersDao {

    Users registerUser(Users entity);
    Users findByUsername(String username);

}
