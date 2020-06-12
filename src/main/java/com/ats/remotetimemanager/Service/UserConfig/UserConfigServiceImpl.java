package com.ats.remotetimemanager.Service.UserConfig;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfig;
import com.ats.remotetimemanager.Repository.UserConfigRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userConfigService")
public class UserConfigServiceImpl implements  UserConfigService {

    @Autowired
    UserConfigRepository userConfigRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserConfig add(UserConfig userConfig) {
        return userConfigRepository.save(userConfig);
    }

    @Override
    public UserConfig update(UserConfig userConfig, Long id) {
        if(userConfigRepository.findById(id).isPresent()){
            UserConfig newUserConfig = userConfigRepository.findByConfigId(id);
            newUserConfig.setTheme(userConfig.getTheme());
            newUserConfig.setshownPlannings(userConfig.getshownPlannings());
            return userConfigRepository.save(newUserConfig);
        }else return null;
    }

    @Override
    public UserConfig findByUserId(Long id) {
        User user = userRepository.findByUserId(id);
        return userConfigRepository.findByUser(user);
    }

}
