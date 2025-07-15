package com.jocata.los.userservice.service;

import com.jocata.los.datamodel.user.form.UserProfile;

import java.util.List;

public interface UserService {

    UserProfile saveUser(UserProfile userProfile);

    UserProfile getUserById(Long id);

    List<UserProfile> getAllUsers();

    UserProfile updateUser(Long id, UserProfile updatedUser);

    String deleteUser(Long id);
}
