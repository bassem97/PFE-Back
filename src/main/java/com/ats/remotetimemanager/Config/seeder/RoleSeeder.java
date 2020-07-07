package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Role;
import com.ats.remotetimemanager.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    @Autowired
    private RoleRepository roleRepository;

    public Role superAdmin = new Role("SUPER_ADMIN");
    public Role admin = new Role("ADMIN");
    public Role chef_department = new Role("CHEF_DEPARTMENT");
    public Role user = new Role("USER");
    public  void seed(){

        if(roleRepository.findAll().isEmpty()){
            roleRepository.save(superAdmin);
            roleRepository.save(admin);
            roleRepository.save(chef_department);
            roleRepository.save(user);
        }
    }
}
