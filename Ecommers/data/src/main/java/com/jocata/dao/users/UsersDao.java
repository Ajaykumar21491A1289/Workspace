package com.jocata.dao.users;

import com.jocata.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersDao extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String userName);
    Optional<Users> findById(Long id);
}
