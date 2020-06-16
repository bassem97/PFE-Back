package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.Notification;
import com.ats.remotetimemanager.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public Notification add(Notification notification) {
        return notificationRepository.save(notification)   ;
    }

    @Override
    public Notification update(Notification notification, Long id) {
       if(notificationRepository.findById(id).isPresent()){
           Notification notif = notificationRepository.findById(id).get();
           notif.setNotifName(notification.getNotifName());
           notif.setNotifDesc(notification.getNotifDesc());
           notif.setNotifDate(notification.getNotifDate());
           notif.setViewed(notification.getViewed());
           return notificationRepository.save(notif);
       }return null;
    }

    @Override
    public Notification findByUserId(long id) {
        return notificationRepository.findById(id);
    }
}
