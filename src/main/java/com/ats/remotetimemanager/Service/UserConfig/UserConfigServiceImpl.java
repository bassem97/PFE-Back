package com.ats.remotetimemanager.Service.UserConfig;

import com.ats.remotetimemanager.Model.UserConfig;
import com.ats.remotetimemanager.Repository.UserConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userConfigService")
public class UserConfigServiceImpl implements  UserConfigService {

    @Autowired
    UserConfigRepository userConfigRepository;

    @Override
    public UserConfig add(UserConfig userConfig) {
        return userConfigRepository.save(userConfig);
    }

    @Override
    public UserConfig update(UserConfig userConfig, Long id) {
        if(userConfigRepository.findById(id).isPresent()){
            UserConfig newUserConfig = userConfigRepository.findByConfigId(id);
            newUserConfig.setSideBar(userConfig.getSideBar());
            newUserConfig.setTheme(userConfig.getTheme());
            newUserConfig.setUser(userConfig.getUser());
            newUserConfig.setPlannings(userConfig.getPlannings());
            return userConfigRepository.save(newUserConfig);
        }else return null;
    }

}
