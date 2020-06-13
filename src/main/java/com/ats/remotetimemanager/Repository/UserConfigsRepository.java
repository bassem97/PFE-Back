package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.UserConfigs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConfigsRepository extends JpaRepository<UserConfigs, Long> {
    UserConfigs findByConfigId(long id);
    UserConfigs findByUser(User user);

//    @Query( value = "SELECT * FROM Users u WHERE u.status = ?1",  nativeQuery = true)
//    UserConfigs find (Integer status);
}
