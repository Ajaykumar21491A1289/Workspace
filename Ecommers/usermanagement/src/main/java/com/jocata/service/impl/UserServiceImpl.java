package com.jocata.service.impl;

import com.jocata.dao.users.*;
import com.jocata.service.UserService;
import com.jocata.users.entity.*;
import com.jocata.users.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao userDao;

    @Autowired
    private PermissionsDao permissionsDao;

    @Autowired
    private RolesDao rolesDao;

    @Autowired
    private UserAddressDao userAddress;

    @Autowired
    private UserRolesDao userRolesDao;

    @Transactional
    @Override
    public UserForm registerUser(UserForm form) {

        Users res = userDao.findByUsername(form.getUserName()).orElse(null);
        if(res!=null) {
            Users user = createUser(form);
            saveUserAddress(form, user);
            Role role = createOrFetchRole(form.getRoleName());
            assignRoleToUser(user, role);

            form.setId(String.valueOf(user.getId()));
            form.setMessage("User Inserted Successfully");
            return form;
        }
        form.setMessage("User Name Already Exist");
        return form;
    }

    @Override
    public String loginUser(String userName, String password) {
        Optional<Users> optionalUser = userDao.findByUsername(userName);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();

            // Plain text comparison (use hashing in production)
            if (user.getPassword().equals(password)) {
                return "Login successful!";
            } else {
                return "Invalid password!";
            }
        } else {
            return "User not found!";
        }
    }

    @Override
    public UserForm updateUser(UserForm form) {
        Optional<Users> optionalUser = userDao.findByUsername(form.getUserName());
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();


            user.setEmail(form.getEmail());
            user.setPassword(form.getPassword());
            userDao.save(user);

            updateUserAddress(form, user);

            form.setMessage("User Updated Successfully");
        }
        else{
            form.setMessage("User Not Foud");
        }

        return form;
    }

    @Override
    public UserForm getUserById(Long id) {
        Users user =userDao.findById(id).orElse(null);
        UserForm form = new UserForm();
        if(user!=null) {
            form.setUserName(user.getUsername());
            form.setPassword(user.getPassword());
            form.setEmail(user.getEmail());
            return form;
        }
        form.setMessage("User Not Found");
        return form;

    }


    private Users createUser(UserForm form) {
        Users user = populateUser(form);
        return userDao.save(user);
    }

    private void saveUserAddress(UserForm form, Users user) {
        UserAddres address = populateAddress(form, user);
        userAddress.save(address);
    }

    private Role createOrFetchRole(String roleName) {
        Optional<Role> existingRole = rolesDao.findByRoleName(roleName);
        return existingRole.orElseGet(() -> {
            Role role = new Role();
            role.setRoleName(roleName);
            return rolesDao.save(role);
        });
    }

    private void assignRoleToUser(Users user, Role role) {
        UserRoleID userRoleID = new UserRoleID();
        userRoleID.setUserId(user.getId());
        userRoleID.setRoleId(role.getId());

        UserRole userRole = new UserRole();
        userRole.setId(userRoleID);
        userRole.setUser(user);
        userRole.setRole(role);

        userRolesDao.save(userRole);
    }

    private Users populateUser(UserForm form) {
        Users user = new Users();
        user.setUsername(form.getUserName());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        return user;
    }

    private UserAddres populateAddress(UserForm form, Users user) {
        UserAddres address = new UserAddres();
        address.setUsers(user);
        address.setAddressLine1(form.getAddressLine1());
        address.setAddressLine2(form.getAddressLine2());
        address.setCity(form.getCity());
        address.setPostalCode(form.getPostalCode());
        address.setCountry(form.getCountry());
        return address;
    }

    private void updateUserAddress(UserForm form, Users user) {

            UserAddres address = new UserAddres();
            address.setAddressLine1(form.getAddressLine1());
            address.setAddressLine2(form.getAddressLine2());
            address.setCity(form.getCity());
            address.setPostalCode(form.getPostalCode());
            address.setCountry(form.getCountry());
            address.setUsers(user);

            userAddress.save(address);
        }




}
