package com.jocata.dao.users;

import com.jocata.users.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsDao extends JpaRepository<Permission,Long> {
}
