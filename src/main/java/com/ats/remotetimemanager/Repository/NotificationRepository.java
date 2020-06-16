package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Notification;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfigs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    Notification findById(long id);
    Notification findByUser (User user);
}
