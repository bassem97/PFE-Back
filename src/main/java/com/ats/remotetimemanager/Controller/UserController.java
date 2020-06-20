package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.NotificationMessageRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    WebSocketController webSocketController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationMessageRepository notificationMessageRepository;

    @GetMapping("list")
    public List<User> getAll(){ return userService.findAll(); }

    @PostMapping("add")
    public User add(@RequestBody User user) throws Exception {
        User user1 = userService.add(user);
        webSocketController.sendMessage(new WebSocketMessage("employee"));
        return user1;
    }

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

    @RequestMapping(value = "/delete/{id}/{idSender}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id, @PathVariable("idSender") Long idSender)  throws Exception {
        User user = userRepository.findByUserId(id);
        NotificationMessage notif ;
        userService.delete(id);
        User sender = userRepository.findByUserId(idSender);
        List<NotificationMessage> notifs = new ArrayList<>();
        for (User us : userRepository.findAll()) {
            if(us.getUserId() != idSender){
                notif= new NotificationMessage("DELETING"
                        ,user.getName()+" "+ user.getFirstName()+ " has been deleted from "+ user.getDepartment().getDepName() + " department by"+
                        sender.getName()+" "+sender.getFirstName()
                        , new Date(), false, false,us);
                notifs.add(notif);
//                    userService.update(us,us.getUserId());
            }
        }
        notificationMessageRepository.saveAll(notifs);
        webSocketController.sendMessage(new WebSocketMessage("employee"));
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public User modify(@RequestBody User user,@PathVariable(value = "id") Long id) throws Exception {
        User user3 = userService.update(user,id);
        webSocketController.sendMessage(new WebSocketMessage("employee"));
        return user3;
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
