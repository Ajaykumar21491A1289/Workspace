package com.jocata.los.userdao;

import com.jocata.los.user.entity.UserDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserDetails, Integer> {
    UserDetails getUserByUsername(String username);
}
