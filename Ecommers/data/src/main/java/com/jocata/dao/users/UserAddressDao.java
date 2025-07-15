package com.jocata.dao.users;

import com.jocata.users.entity.UserAddres;
import com.jocata.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressDao extends JpaRepository<UserAddres,Long> {

}
