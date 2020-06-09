package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Service.User.UserService;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> getAll(){ return userService.findAll(); }

    @PostMapping("add")
    public User add(@RequestBody User user) { return userService.add(user); }

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public User getUserByAuth() {
        return userService.findByUserCIN(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Long id){
         return userService.findById(id);
    }

//    @RequestMapping(value = "/auth", method = RequestMethod.GET)
//    public User getUserByAuth() {
//        return userService.findByUserCIN(SecurityContextHolder.getContext().getAuthentication().getName());
//    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public User modify(@RequestBody User user,@PathVariable(value = "id") Long id){
        return userService.update(user,id);
    }

    @RequestMapping(value = "changePassword/{UserCIN}", method = RequestMethod.POST)
    public Boolean changePassword(@RequestBody ChangePasswordVM user, @PathVariable(value = "CIN") String username){
        return userService.changePassword(user, username);
    }
    @RequestMapping(value = "/userByUserCIN/{UserCIN}", method = RequestMethod.GET)
    public User findByCIN(@PathVariable(value = "CIN") String us){
        return userService.findByUserCIN(us);
    }


}
