package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Model.Role;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.AddressRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsersSeeder {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentSeeder departmentSeeder;

    @Autowired
    private PostSeeder postSeeder;

    @Autowired
    private RoleSeeder roleSeeder;

    @Autowired
    private AddressRepository addressRepository ;


    public void seed(){
            if(userService.findAll().isEmpty()){
                ArrayList<Role> rolesAdmin = new ArrayList<>();
                rolesAdmin.add(roleSeeder.admin);
                ArrayList<Role> rolesUser = new ArrayList<>();
                rolesUser.add(roleSeeder.user);
//            ArrayList<Role> rolesBoth = new ArrayList<>();
//            rolesBoth.add(admin);
//            rolesBoth.add(user);


                User user1= new User(1L,"bassem  jadoui", "male",
                        "1997/05/05",55135774,
                        "bassemjadoui1996@gmail.com", "05796481", "123456",postSeeder.employer, departmentSeeder.info);
                user1.setRoles(rolesAdmin);
                userService.add(user1);
                User user2 = new User(2L,"khaili med amine ", "male",
                        "1997/02/04",24222365,
                        "medamine@gmail.com", "12545852", "123456",postSeeder.chef_department, departmentSeeder.mark);
                user2.setRoles(rolesAdmin);
                userService.add(user2);
                User user3 = new User(3L,"test test", "female",
                        "2020/03/09",20000000,
                        "test@gmail.com", "12345678", "123456",postSeeder.employee, departmentSeeder.security);
                user3.setRoles(rolesUser);
                userService.add(user3);
                Address ad1 = new Address("kalaa kebira","30","ariena","borj louzir", 2036,user1 );
                Address ad2 = new Address("nahj  za3ter","b254","ariena","hedi nouira", 2037, user2);
                Address ad3 = new Address("test","203","test","test", 1111, user3);

                if(addressRepository.findAll().isEmpty()){
                    addressRepository.save(ad1);
                    addressRepository.save(ad2);
                    addressRepository.save(ad3);
                }
            }

        }
    }

