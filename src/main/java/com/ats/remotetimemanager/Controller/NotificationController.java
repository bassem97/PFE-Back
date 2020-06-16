package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Notification;
import com.ats.remotetimemanager.Service.Notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/notif/")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("add")
    public Notification add(Notification notification) {
        return notificationService.add(notification);
    }

    @PutMapping("update/{id}")
    public Notification update(@Valid @RequestBody Notification notification, @PathVariable("id") Long id) {
        return notificationService.update(notification,id);
    }

    @GetMapping("findById/{id}")
    public Notification findByUserId(@PathVariable("id") long id) {
        return notificationService.findByUserId(id);
    }
}
