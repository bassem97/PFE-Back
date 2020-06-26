package com.ats.remotetimemanager.Controller;


import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Model.UserConfigs;
import com.ats.remotetimemanager.Service.UserConfig.UserConfigsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/userConfigs/")
public class UserConfigsController {

    @Autowired
    UserConfigsService userConfigsService;

    @Autowired
    WebSocketController webSocketController;

    @PostMapping("add")
    public UserConfigs add(@RequestBody UserConfigs userConfigs){
        return userConfigsService.add(userConfigs);
    }

    @PutMapping("/update/{id}/{sender}")
    public UserConfigs update(@RequestBody UserConfigs userConfigs, @PathVariable(value = "id") Long id, @PathVariable(value = "sender") Long sender) throws Exception {
        UserConfigs userConfigs3 = userConfigsService.update(userConfigs,id);
        if (sender == 2) {
            webSocketController.sendMessage(new WebSocketMessage("userConfig", userConfigs3.getUser().getUserId(), userConfigs3.getTheme()));
        }
        return userConfigs3;

    }
    @GetMapping("/findByUserId/{id}")
    public UserConfigs findByUserId(@PathVariable(value = "id") Long id){

        return userConfigsService.findByUserId(id);
    }
}
