package com.ats.remotetimemanager.Controller;


import com.ats.remotetimemanager.Model.UserConfigs;
import com.ats.remotetimemanager.Service.UserConfig.UserConfigsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/userConfigs   /")
public class UserConfigsController {

    @Autowired
    UserConfigsService userConfigsService;

    @PostMapping("add")
    public UserConfigs add(@RequestBody UserConfigs userConfigs){
        return userConfigsService.add(userConfigs);
    }

    @PutMapping("/update/{id}")
    public UserConfigs update(@RequestBody UserConfigs userConfigs, @PathVariable(value = "id") Long id){
        return userConfigsService.update(userConfigs,id);
    }
    @GetMapping("/findByUserId/{id}")
    public UserConfigs update(@PathVariable(value = "id") Long id){

        return userConfigsService.findByUserId(id);
    }
}
