package com.jocata.los.data.user.dao;

import com.jocata.los.datamodel.user.entity.User;
import com.jocata.los.datamodel.user.form.UserProfile;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO  {

    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User updatedUser);

    String deleteUser(User user);


}
