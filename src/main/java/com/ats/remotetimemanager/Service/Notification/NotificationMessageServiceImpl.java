package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationMessageServiceImpl implements NotificationMessageService {

    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public NotificationMessage add(NotificationMessage notificationMessage) {
        return notificationRepository.save(notificationMessage)   ;
    }

    @Override
    public NotificationMessage update(NotificationMessage notificationMessage, Long id) {
       if(notificationRepository.findById(id).isPresent()){
           NotificationMessage notif = notificationRepository.findById(id).get();
           notif.setNotifTitle(notificationMessage.getNotifTitle());
           notif.setNotifDesc(notificationMessage.getNotifDesc());
           notif.setNotifDate(notificationMessage.getNotifDate());
           notif.setViewed(notificationMessage.getViewed());
           return notificationRepository.save(notif);
       }return null;
    }

    @Override
    public void delete(Long id) {
        NotificationMessage notif = notificationRepository.findById(id).get();
        notificationRepository.delete(notif);
    }
}
