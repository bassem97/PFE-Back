package com.ats.remotetimemanager.Controller;


import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfig;
import com.ats.remotetimemanager.Service.UserConfig.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/userConfig/")
public class UserConfigController {

    @Autowired
    UserConfigService userConfigService;

    @PostMapping("add")
    public UserConfig add(@RequestBody UserConfig userConfig){
        return userConfigService.add(userConfig);
    }

    @PutMapping("/update/{id}")
    public UserConfig update(@RequestBody UserConfig userConfig, @PathVariable(value = "id") Long id){
        return userConfigService.update(userConfig,id);
    }
    @GetMapping("/findByUser")
    public UserConfig update(@RequestBody User user){
        return userConfigService.findByUser(user);
    }
}
