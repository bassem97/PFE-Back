package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.NotificationMessage;

import java.util.List;

public interface NotificationMessageService {
    NotificationMessage add(NotificationMessage notificationMessage);
    NotificationMessage update(NotificationMessage notificationMessage, Long id);
    List<NotificationMessage> findAll();
     void delete(Long id);
}
