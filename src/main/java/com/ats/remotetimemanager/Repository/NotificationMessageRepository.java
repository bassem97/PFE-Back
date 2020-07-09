package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.NotificationMessage;
import com.ats.remotetimemanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationMessageRepository extends JpaRepository<NotificationMessage,Long> {
    NotificationMessage findById(long id);
    NotificationMessage findByUser (User user);
    List<NotificationMessage> findAllByUser(User user);
    List<NotificationMessage> findAllByIdTarget(Long id);
}
