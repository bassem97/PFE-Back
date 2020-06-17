package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Service.Notification.NotificationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PutMapping("update/{id}")
    public NotificationMessage update(@Valid @RequestBody NotificationMessage notificationMessage, @PathVariable("id") Long id) {
        return notificationMessageService.update(notificationMessage,id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
         notificationMessageService.delete(id);
    }
}
