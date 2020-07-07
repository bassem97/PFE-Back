package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.TempUser;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.Notification.NotificationMessageService;
import com.ats.remotetimemanager.Service.TempUser.TempUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/tempUser/")
public class TempUserController {

    @Autowired
    TempUserService tempUserService;

    @Autowired
    WebSocketController webSocketController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private NotificationMessageService notificationMessageService;

    @PostMapping("add/{idSender}")
    public TempUser add(@Valid @RequestBody TempUser tempUser, @PathVariable("idSender") Long idSender) throws Exception {
        TempUser tmp = tempUserService.add(tempUser);
        User sender = userRepository.findByUserId(idSender);
        NotificationMessage notif;
        List<NotificationMessage> notifs = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            if (user.isAdmin() || user.isSuperAdmin()) {
                notif = new NotificationMessage("Add request"
                        , sender.getName() + " " + sender.getFirstName() + " wants to add a new employee "
                        , new Date(), false, false, user, tempUser.getUserId());
                notifs.add(notif);
            }
        }
        notificationMessageService.saveAll(notifs);
        webSocketController.sendMessage(new WebSocketMessage("tempUser"));
        return tmp;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        tempUserService.delete(id);
    }

    @GetMapping("findById/{id}")
    public TempUser findByUserCIN(@PathVariable("id") long id) {
        return tempUserService.findById(id);
    }

    @PostMapping("acceptRequest/{action}")
    public User acceptRequest(@Valid @RequestBody TempUser tempUser, @PathVariable("action") String action) throws Exception {
        User userAdded = tempUserService.acceptRequest(tempUser, action);
        NotificationMessage notif;
        for (User user: userRepository.findAll()) {
            if(user.getDepartment().getDepId() == tempUser.getDepartment().getDepId() && user.isChefDep()){
                notif = new NotificationMessage("Add request accepted"
                        ,  "Request to add "+tempUser.getName()+" "+tempUser.getFirstName()+" "+" has been accepted"
                        , new Date(), false, false, user);
                notificationMessageService.add(notif);
                break;
            }
        }
        webSocketController.sendMessage(new WebSocketMessage("tempUserAdded"));
        return userAdded;
    }

    @DeleteMapping("declineRequest/{idUser}")
    public TempUser declineRequest(@PathVariable("idUser") long id) throws Exception {
        TempUser userDeclined = tempUserService.declineRequest(id);
        NotificationMessage notif;
        for (User user: userRepository.findAll()) {
            if (user.getDepartment().getDepId() == userDeclined.getDepartment().getDepId() && user.isChefDep()) {
                notif = new NotificationMessage("Add request declined"
                        , "Your request to add " + userDeclined.getName() + " " + userDeclined.getFirstName()+" has been declined"
                        , new Date(), false, false, user);
                notificationMessageService.add(notif);
                break;
            }
        }
        webSocketController.sendMessage(new WebSocketMessage("tempUser"));
        return userDeclined;
    }
}
