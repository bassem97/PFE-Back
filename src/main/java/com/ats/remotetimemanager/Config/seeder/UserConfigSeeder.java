package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfig;
import com.ats.remotetimemanager.Repository.PlanningRepository;
import com.ats.remotetimemanager.Repository.UserConfigRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConfigSeeder {

    @Autowired
    UserConfigRepository userConfigRepository;

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



        int[] l = {1,2,3,4};


        UserConfig userConfig1 = new UserConfig(true , user1,l );
        UserConfig userConfig2 = new UserConfig(false , user2, l );
        UserConfig userConfig3 = new UserConfig(true , user3, l  );
        UserConfig userConfig4 = new UserConfig(false , user4 ,l);

        if(userConfigRepository.findAll().isEmpty()){
            userConfigRepository.save(userConfig1);
            userConfigRepository.save(userConfig2);
            userConfigRepository.save(userConfig3);
            userConfigRepository.save(userConfig4);
        }
    }

}
