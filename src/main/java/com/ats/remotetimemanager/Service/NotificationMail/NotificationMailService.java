package com.ats.remotetimemanager.Service.NotificationMail;

import com.ats.remotetimemanager.Model.User;
import org.springframework.mail.MailException;

import javax.xml.crypto.Data;

public interface NotificationMailService {

    public void sendNotification(User user, String password) throws MailException;
    public void sendFeedback(Data data);
}

