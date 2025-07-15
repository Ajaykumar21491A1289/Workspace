package com.jocata.dao.users;

import com.jocata.users.entity.UserRole;
import com.jocata.users.entity.UserRoleID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesDao extends JpaRepository<UserRole, UserRoleID> {
}
