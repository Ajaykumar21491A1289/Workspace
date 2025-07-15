package com.jocata.microservices.entity;

import com.jocata.microservices.util.Roles;
import jakarta.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRoles {

    @Id
    @OneToOne
    @JoinColumn(name="user_id")
    private Users users;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
