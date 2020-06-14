package com.ats.remotetimemanager.Service.UserConfig;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfigs;
import com.ats.remotetimemanager.Repository.UserConfigsRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

@Service("userConfigService")
public class UserConfigsServiceImpl implements UserConfigsService {

    @Autowired
    UserConfigsRepository userConfigsRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserConfigs add(UserConfigs userConfigs) {
        return userConfigsRepository.save(userConfigs);
    }

    @Override
    public UserConfigs update(UserConfigs userConfigs, Long id) {
        if(userConfigsRepository.findById(id).isPresent()){
            UserConfigs newUserConfigs = userConfigsRepository.findByConfigId(id);
            newUserConfigs.setTheme(userConfigs.getTheme());
            newUserConfigs.setShownPlannings(userConfigs.getShownPlannings());
            return userConfigsRepository.save(newUserConfigs);
        }else return null;
    }

    @Override
    public UserConfigs findByUserId(Long id) {
        User user = userRepository.findByUserId(id);
        return userConfigsRepository.findByUser(user);
    }
}
