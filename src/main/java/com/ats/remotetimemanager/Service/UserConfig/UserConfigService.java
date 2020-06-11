package com.ats.remotetimemanager.Service.UserConfig;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfig;

public interface UserConfigService  {
    UserConfig add(UserConfig userConfig);
    UserConfig update(UserConfig userConfig, Long id);
    UserConfig findByUser(User user);
}
