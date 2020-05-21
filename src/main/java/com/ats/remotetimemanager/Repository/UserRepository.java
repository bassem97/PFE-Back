package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserCIN(String CIN);
    User findById(long id);
}