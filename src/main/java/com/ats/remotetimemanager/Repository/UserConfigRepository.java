package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
    UserConfig findByConfigId(long id);
    UserConfig findByUser(User user);

//    @Query( value = "SELECT * FROM Users u WHERE u.status = ?1",  nativeQuery = true)
//    UserConfig find (Integer status);
}
