package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.NotificationMessage;

public interface NotificationMessageService {
    NotificationMessage add(NotificationMessage notificationMessage);
    NotificationMessage update(NotificationMessage notificationMessage, Long id);
    void delete(Long id);
}
