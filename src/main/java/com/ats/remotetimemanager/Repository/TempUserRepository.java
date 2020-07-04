package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface TempUserRepository extends JpaRepository<TempUser,Long> {
    TempUser findByCin(String cin);
}
