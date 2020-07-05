package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.*;import com.ats.remotetimemanager.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class UsersSeeder {

    @Autowired
    private UserService userService;
    @Autowired
    private PostSeeder postSeeder;
    @Autowired
    private RoleSeeder roleSeeder;
    @Autowired
    private ScheduleSeeder scheduleSeeder;



    public void seed() throws Exception {
        User user1= new User("bassem", "jadoui", "male",
                "1997-05-05","+21655135774",
                "bassemjadoui1996@gmail.com", "07496483", "123456",postSeeder.chef_department, scheduleSeeder.info,"1.jpg");
        User user2 = new User(" Med Amine ", "Khaili", "male",
                "1997-02-04","+21624222365",
                "khaili.amine@hotmail.fr", "07492487", "123456",postSeeder.designer, scheduleSeeder.mark,"2.jpg");
        User user3 = new User("manai", "karim", "female",
                "2020-03-09","+21620000000",
                "manai@gmail.com", "12345678", "123456",postSeeder.tester, scheduleSeeder.security,"3.jpg");
        User user4 = new User("zaroui", "montassar", "male",
                "2020-03-09","+21620500000",
                "tatay@gmail.com", "152345678", "1234556",postSeeder.tester, scheduleSeeder.khra,"4.jpg");
        User user5 = new User("degla", "malek", "male",
                "2020-03-09","+21620500021",
                "degla@gmail.com", "01234567", "1234556",postSeeder.tester, scheduleSeeder.khra,"5.jpg");

            Address ad1 = new Address("kalaa kebira","30","ariena","borj louzir", 2036);
            Address ad2 = new Address("nahj  za3ter","b254","ariena","hedi nouira", 2037);
            Address ad3 = new Address("test","203","test","test", 1111);
            Address ad4 = new Address("solidarité","214","ariena","borj louzir", 1325);
            Address ad5 = new Address("hdid","145","fouchena","tunis", 1023);

            int[] l = {1,2,3,4};
            UserConfigs userConfigs1 = new UserConfigs(true ,l );
            UserConfigs userConfigs2 = new UserConfigs(false , l );
            UserConfigs userConfigs3 = new UserConfigs(true , l  );
            UserConfigs userConfigs4 = new UserConfigs(false , l);
            UserConfigs userConfigs5 = new UserConfigs(false , l);

            NotificationMessage notif1 = new NotificationMessage("notification name 1","notification description 1", new Date(),false,false);
            NotificationMessage notif2 = new NotificationMessage("notification name 2","notification description 2", new Date(),false,false);
            NotificationMessage notif3 = new NotificationMessage("notification name 3","notification description 3", new Date(),false,false);
            NotificationMessage notif4 = new NotificationMessage("notification name 4","notification description 4", new Date(),false,false);
            NotificationMessage notif5 = new NotificationMessage("notification name 5","notification description 5", new Date(),false,false);
            NotificationMessage notif6 = new NotificationMessage("notification name 6","notification description 6", new Date(),false,false);
            NotificationMessage notif7 = new NotificationMessage("notification name 7","notification description 7", new Date(),false,false);
            NotificationMessage notif8 = new NotificationMessage("notification name 8","notification description 8", new Date(),false,false);

            List<NotificationMessage> notifs = new ArrayList<>();
            notifs.add(notif1);
            notifs.add(notif2);
            notifs.add(notif3);
            notifs.add(notif4);
            notifs.add(notif5);
            notifs.add(notif6);
            notifs.add(notif7);
            notifs.add(notif8);



            Attendance att1 = new Attendance("CHECK IN","finger",495, LocalDate.now().plusDays(1));
            Attendance att2 = new Attendance("CHECK OUT","finger",1020, LocalDate.now().plusDays(1));
            Attendance att3 = new Attendance("CHECK IN","finger",500, LocalDate.now().plusDays(1));
            Attendance att4 = new Attendance("CHECK OUT","finger",900, LocalDate.now().plusDays(1));
            Attendance att5 = new Attendance("CHECK OUT","finger",900, LocalDate.now().plusDays(1));




            ArrayList<Role> rolesAdmin = new ArrayList<>();
                rolesAdmin.add(roleSeeder.admin);
            ArrayList<Role> rolesChefDep = new ArrayList<>();
            rolesChefDep.add(roleSeeder.chef_department);
                ArrayList<Role> rolesUser = new ArrayList<>();
                rolesUser.add(roleSeeder.user);
//            ArrayList<Role> rolesBoth = new ArrayList<>();
//            rolesBoth.add(admin);
//            rolesBoth.add(user);



//            user1.setRoles(rolesChefDep);
            user1.setAddresses(Arrays.asList(ad1));
            user1.setUserConfigs(Arrays.asList(userConfigs1));
            user1.setNotificationMessages(notifs);
            System.out.println(user1);
            userService.add(user1);

//            user2.setRoles(rolesAdmin);
            user2.setAddresses(Arrays.asList(ad2));
            user2.setUserConfigs(Arrays.asList(userConfigs2));
            user2.setNotificationMessages(notifs);
            System.out.println(user2);
            userService.add(user2);


//            user3.setRoles(rolesUser);
            user3.setAddresses(Arrays.asList(ad3));
            user3.setUserConfigs(Arrays.asList(userConfigs3));
            user3.setNotificationMessages(notifs);
            System.out.println(user3);
            userService.add(user3);


//            user4.setRoles(rolesUser);
            user4.setAddresses(Arrays.asList(ad4));
            user4.setUserConfigs(Arrays.asList(userConfigs4));
            user4.setNotificationMessages(notifs);
            System.out.println(user4);
            userService.add(user4);

        user5.setAddresses(Arrays.asList(ad5));
        user5.setUserConfigs(Arrays.asList(userConfigs5));
        user5.setNotificationMessages(notifs);
        System.out.println(user4);
        userService.add(user5);
//            for (int i=5;i<10;i++) {
//                user4.setImage(i+".jpg");
//                user4.setCin(i+"545485");
//                user4.setEmail("qsd"+i+"@qsdqs.fqs");
//                user4.setPhone("55545"+i);
//                user4.setUserId(user4.getUserId()+1);
//                userService.add(user4);
//            }
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