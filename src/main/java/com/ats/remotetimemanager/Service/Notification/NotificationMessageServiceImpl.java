package com.ats.remotetimemanager.Service.Notification;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.NotificationMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationMessageServiceImpl implements NotificationMessageService {

    @Autowired
    NotificationMessageRepository notificationMessageRepository;
    @Override
    public NotificationMessage add(NotificationMessage notificationMessage) {
        return notificationMessageRepository.save(notificationMessage)   ;
    }

    @Override
    public NotificationMessage update(NotificationMessage notificationMessage, Long id, Long sender) {
        if (sender == 1) {
            if (notificationMessageRepository.findById(id).isPresent()) {
                NotificationMessage notif = notificationMessageRepository.findById(id).get();
                notif.setNotifTitle(notificationMessage.getNotifTitle());
                notif.setNotifDesc(notificationMessage.getNotifDesc());
                notif.setNotifDate(notificationMessage.getNotifDate());
                notif.setIsViewed(notificationMessage.getIsViewed());
                notif.setIsHovered(notificationMessage.getIsHovered());
                notif.setIdTarget(notificationMessage.getIdTarget());
                return notificationMessageRepository.save(notif);
            }
        } else {
            updateAll(notificationMessage);
        }

        return null;
    }

    public List<NotificationMessage> updateAll(NotificationMessage notificationMessage) {
        List<NotificationMessage> notifs = notificationMessageRepository.findAllByIdTarget(notificationMessage.getIdTarget());
        notifs.forEach(notificationMessage1 -> {
            notificationMessage1.setIdTarget(0);
            notificationMessageRepository.save(notificationMessage1);
        });
        notifs = notificationMessageRepository.saveAll(notifs);
        return notifs;
    }

    @Override
    public List<NotificationMessage> findAll() {
        return notificationMessageRepository.findAll();
    }

    @Override
    public List<NotificationMessage> findAllByUser(User user) {
        return notificationMessageRepository.findAllByUser(user);
    }

    @Override
    public void delete(Long id) {
        NotificationMessage notif = notificationMessageRepository.findById(id).get();
        notificationMessageRepository.delete(notif);
    }

    @Override
    public List<NotificationMessage> saveAll(List<NotificationMessage> notifs) {
        return notificationMessageRepository.saveAll(notifs);
    }
}
