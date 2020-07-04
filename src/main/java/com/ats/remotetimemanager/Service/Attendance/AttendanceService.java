package com.ats.remotetimemanager.Service.Attendance;

import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.User;

import java.util.List;

public interface AttendanceService {
    Attendance add(Attendance attendance);
    List<Attendance> findAll();
    Attendance update(Attendance attendance, Long id);
    void delete(long id);
    Attendance findById(long id);
    List<Attendance> findByUser(User user);

}
