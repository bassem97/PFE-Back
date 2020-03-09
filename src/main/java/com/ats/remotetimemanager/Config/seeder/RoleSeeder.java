package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Role;
import com.ats.remotetimemanager.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    @Autowired
    private RoleRepository roleRepository;

    Role admin = new Role("ADMIN");
    Role user = new Role("USER");
    public  void seed(){

        if(roleRepository.findAll().isEmpty()){
            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }
}
