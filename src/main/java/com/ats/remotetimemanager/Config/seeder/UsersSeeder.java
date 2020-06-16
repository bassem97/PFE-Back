package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.*;
import com.ats.remotetimemanager.Repository.AddressRepository;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UsersSeeder {

    @Autowired
    private UserRepository userRepository ;

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

    @Autowired
    private DepartmentRepository departmentRepository ;







    public void print(User user){
        System.out.println(user.toString());
    }
    public void seed(){
        if(userRepository.findAll().isEmpty()){
            User user1= new User("bassem", "jadoui", "male",
                    "1997-05-05","+21655135774",
                    "bassemjadoui1996@gmail.com", "07496483", "123456",postSeeder.employer, departmentSeeder.info,"1.jpg");
            User user2 = new User(" Med Amine ", "Khaili", "male",
                    "1997-02-04","+21624222365",
                    "medamine@gmail.com", "07492487", "123456",postSeeder.chef_department, departmentSeeder.mark,"2.png");
            User user3 = new User("test", "test", "female",
                    "2020-03-09","+21620000000",
                    "test@gmail.com", "12345678", "123456",postSeeder.employee, departmentSeeder.security,"3.jpg");
            User user4 = new User("erreur", "test", "erreur",
                    "2020-03-09","+21620500000",
                    "erreru@gmail.com", "152345678", "1234556",postSeeder.chef_department, departmentSeeder.info,"4.png");

            Address ad1 = new Address("kalaa kebira","30","ariena","borj louzir", 2036);
            Address ad2 = new Address("nahj  za3ter","b254","ariena","hedi nouira", 2037);
            Address ad3 = new Address("test","203","test","test", 1111);

            int[] l = {1,2,3,4};
            UserConfigs userConfigs1 = new UserConfigs(true ,l );
            UserConfigs userConfigs2 = new UserConfigs(false , l );
            UserConfigs userConfigs3 = new UserConfigs(true , l  );
            UserConfigs userConfigs4 = new UserConfigs(false , l);

            Notification notif1 = new Notification("notification name 1","notification description 1", LocalDate.now(),false);
            Notification notif2 = new Notification("notification name 2","notification description 2", LocalDate.now(),false);
            Notification notif3 = new Notification("notification name 3","notification description 3", LocalDate.now(),true);
            Notification notif4 = new Notification("notification name 4","notification description 4", LocalDate.now(),false);
            Notification notif5 = new Notification("notification name 5","notification description 5", LocalDate.now(),false);
            Notification notif6 = new Notification("notification name 6","notification description 6", LocalDate.now(),true);
            Notification notif7 = new Notification("notification name 7","notification description 7", LocalDate.now(),true);
            Notification notif8 = new Notification("notification name 8","notification description 8", LocalDate.now(),false);

            List<Notification> notifs = new ArrayList<>();
            notifs.add(notif1);
            notifs.add(notif2);
            notifs.add(notif3);
            notifs.add(notif4);
            notifs.add(notif5);
            notifs.add(notif6);
            notifs.add(notif7);
            notifs.add(notif8);

            ArrayList<Role> rolesAdmin = new ArrayList<>();
                rolesAdmin.add(roleSeeder.admin);
                ArrayList<Role> rolesUser = new ArrayList<>();
                rolesUser.add(roleSeeder.user);
//            ArrayList<Role> rolesBoth = new ArrayList<>();
//            rolesBoth.add(admin);
//            rolesBoth.add(user);



            user1.setRoles(rolesAdmin);
            user1.setAddresses(Arrays.asList(ad1));
            user1.setUserConfigs(Arrays.asList(userConfigs1));
            user1.setNotifications(notifs);
            System.out.println(user1);
            userService.add(user1);

            user2.setRoles(rolesAdmin);
            user2.setAddresses(Arrays.asList(ad2));
            user2.setUserConfigs(Arrays.asList(userConfigs2));
            user2.setNotifications(notifs);
            System.out.println(user2);
            userService.add(user2);


            user3.setAddresses(Arrays.asList(ad3));
            user3.setUserConfigs(Arrays.asList(userConfigs3));
            user3.setNotifications(notifs);
            System.out.println(user3);
            userService.add(user3);


            user4.setRoles(rolesUser);
            user4.setUserConfigs(Arrays.asList(userConfigs4));
            user4.setNotifications(notifs);
            System.out.println(user4);
            userService.add(user4);
//                User user4 = new User("erreur", "erreur",
//                        "2020/03/09",205000000,
//                        "erreru@gmail.com", "152345678", "1234556",postSeeder.chef_department, departmentSeeder.info);
//                departmentSeeder.info.getUsers().add(user4);
//                departmentRepository.save(departmentSeeder.info);
//                if(addressRepository.findAll().isEmpty()){
//                    addressRepository.save(ad1);
//                    addressRepository.save(ad2);
//                    addressRepository.save(ad3);
//                }
            }
//            user3.setPost(postSeeder.chef_department);
//            System.out.println("BDEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//            userService.update(user3,user3.getUserId());
//            System.out.println("WWWFFFEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//
//            user1.setPost(postSeeder.chef_department);
//            userService.update(user1,user1.getUserId());


        }
    }

