package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.User;

import java.util.List;

public interface NotificationMessageService {
    NotificationMessage add(NotificationMessage notificationMessage);
    NotificationMessage update(NotificationMessage notificationMessage, Long id, Long sender);
    List<NotificationMessage> updateAll(NotificationMessage notificationMessage);
    List<NotificationMessage> findAll();
    List<NotificationMessage> findAllByUser(User user);

     void delete(Long id);

    List<NotificationMessage> saveAll(List<NotificationMessage> notifs);
}
