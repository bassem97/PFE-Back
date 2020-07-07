package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.NotificationMessageRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.Notification.NotificationMessageService;
import com.ats.remotetimemanager.Service.User.UserService;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private NotificationMessageService notificationMessageService;

    @GetMapping("list")
    public List<User> getAll(){ return userService.findAll(); }

    @GetMapping("makeRevokeAdmin/{id}/{role}")
    public User makeRemoveAdmin(@PathVariable(value = "id") Long id, @PathVariable(value = "role") Long role)
    { return userService.makeRevokeAdmin(id, role); }


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

    @RequestMapping(value = "/firstTime", method = RequestMethod.GET)
    public boolean getFistTime(){
        return userService.findAll().isEmpty();
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
            if(us.getUserId() != idSender && (us.isAdmin() || us.isChefDep() || us.isSuperAdmin())){
                notif= new NotificationMessage("User deleted"
                        ,user.getName()+" "+ user.getFirstName()+ " has been deleted from "+ user.getDepartment().getDepName() + " department by "+
                        sender.getName()+" "+sender.getFirstName()
                        , new Date(), false, false,us);
                notifs.add(notif);
//                    userService.update(us,us.getUserId());
            }
        }
        notificationMessageService.saveAll(notifs);
        webSocketController.sendMessage(new WebSocketMessage("employee"));
    }

    @RequestMapping(value="/update/{id}/{sender}", method = RequestMethod.PUT)
    public User modify(@RequestBody User user, @PathVariable(value = "id") Long id, @PathVariable(value = "sender") Long sender) throws Exception {
        User user3 = userService.update(user,id);
        if (sender == 1) {
            webSocketController.sendMessage(new WebSocketMessage("employee"));
        } else if (sender == 2) {
            webSocketController.sendMessage(new WebSocketMessage("post"));
        } else if (sender == 3) {
            webSocketController.sendMessage(new WebSocketMessage("profile"));
        }
        return user3;
    }

    @PutMapping("requestUpdate/{id}")
    public User requestUpdate(@Valid @RequestBody User user, @PathVariable("id") Long id) {
        return userService.requestUpdate(user,id);
    }


    @RequestMapping(value = "changePassword/{UserCIN}", method = RequestMethod.POST)
    public Boolean changePassword(@RequestBody ChangePasswordVM user, @PathVariable(value = "UserCIN") String username){
        return userService.changePassword(user, username);
    }
    @RequestMapping(value = "/userByUserCIN/{UserCIN}", method = RequestMethod.GET)
    public User findByCIN(@PathVariable(value = "UserCIN") String us){
        return userService.findByUserCIN(us);
    }

    @GetMapping("role")
    public Set<SimpleGrantedAuthority> getAuthority(@RequestBody User user){
        return userService.getAuthority(user);
    }



}
