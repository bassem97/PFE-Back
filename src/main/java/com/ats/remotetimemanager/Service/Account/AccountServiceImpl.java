package com.ats.remotetimemanager.Service.Account;

import com.ats.remotetimemanager.Model.Role;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService{
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private RoleRepository roleRepository ;

    @Override
    public void addRoleToUser(String CIN, String roleName) {
        User user = userRepository.findByCIN(CIN);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }
}
