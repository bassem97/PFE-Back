package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.TempUser;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Service.TempUser.TempUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/tempUser/")
public class TempUserController {

    @Autowired
    TempUserService tempUserService;

    @PostMapping("add")
    public TempUser add(@Valid @RequestBody TempUser tempUser) {
        return tempUserService.add(tempUser);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        tempUserService.delete(id);
    }

    @GetMapping("findByCin/{cin}")
    public TempUser findByUserCIN(@PathVariable("cin") String cin) {
        return tempUserService.findByUserCIN(cin);
    }

    @PostMapping("acceptRequest/{action}")
    public User acceptRequest(@Valid @RequestBody TempUser tempUser, @PathVariable("action") String action) throws Exception {
        return tempUserService.acceptRequest(tempUser, action);
    }
}
