package com.jocata.dao.users;

import com.jocata.users.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesDao extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(String roleName);
}
