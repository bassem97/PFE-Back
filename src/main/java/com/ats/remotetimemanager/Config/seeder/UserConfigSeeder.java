package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.PlanningRepository;
import com.ats.remotetimemanager.Repository.UserConfigsRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConfigSeeder {

    @Autowired
    UserConfigsRepository userConfigsRepository;

    @Autowired
    UsersSeeder usersSeeder ;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlanningRepository planningRepository;

    public void seed(){
        User user1 = userRepository.findByUserId(1);
        User user2 = userRepository.findByUserId(2);
        User user3 = userRepository.findByUserId(3);
        User user4 = userRepository.findByUserId(4);







//
//        if(userConfigRepository.findAll().isEmpty()){
//            userConfigRepository.save(userConfig1);
//            userConfigRepository.save(userConfig2);
//            userConfigRepository.save(userConfig3);
//            userConfigRepository.save(userConfig4);
//        }
    }

}
