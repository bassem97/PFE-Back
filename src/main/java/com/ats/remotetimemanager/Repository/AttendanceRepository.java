package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Attendance findById(long attId);
    List<Attendance> findAllByUser(User user);

}
