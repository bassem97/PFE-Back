package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Absence;
import com.ats.remotetimemanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    List<Absence> findAllByUser(User user);
}
