package com.ats.remotetimemanager.Service.UserConfig;

import com.ats.remotetimemanager.Model.UserConfigs;

public interface UserConfigsService {
    UserConfigs add(UserConfigs userConfigs);
    UserConfigs update(UserConfigs userConfigs, Long id);
    UserConfigs findByUserId(Long id);
}
