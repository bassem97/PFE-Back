package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SeedByOrder {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    DepartmentSeeder departmentSeeder ;
    @Autowired
    RoleSeeder roleSeeder;
    @Autowired
    UsersSeeder usersSeeder;
    @Autowired
    PostSeeder postSeeder;

    @Autowired
    private UserService userService;

    public void init()  {

        departmentSeeder.seed();
        roleSeeder.seed();
        postSeeder.seed();
        usersSeeder.seed();






    }
}
