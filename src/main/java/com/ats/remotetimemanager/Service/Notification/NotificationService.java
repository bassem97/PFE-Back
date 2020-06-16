package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.Notification;

public interface NotificationService {

    Notification add(Notification notification);
    Notification update(Notification notification, Long id);
    Notification findByUserId(long id);

}
