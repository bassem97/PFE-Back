package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Service.Notification.NotificationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notification/")
public class NotificationMessageController {

    @Autowired
    NotificationMessageService notificationMessageService;

    @PostMapping("add")
    public NotificationMessage add(NotificationMessage notificationMessage) {
        return notificationMessageService.add(notificationMessage);
    }

    @PutMapping("update/{id}/{sender}")
    public NotificationMessage update(@Valid @RequestBody NotificationMessage notificationMessage, @PathVariable("id") Long id, @PathVariable("sender") Long sender) {
        return notificationMessageService.update(notificationMessage, id, sender);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        notificationMessageService.delete(id);
    }

    @GetMapping("list")
    public List<NotificationMessage> findAll() {
        return notificationMessageService.findAll();
    }

    @GetMapping("listByUser")
    public List<NotificationMessage> findAllByUser(@Valid @RequestBody User user) {
        return notificationMessageService.findAllByUser(user);
    }

}
