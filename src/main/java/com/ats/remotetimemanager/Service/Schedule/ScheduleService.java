package com.ats.remotetimemanager.Service.Schedule;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule add(Schedule schedule);
    Schedule update(Schedule schedule, Long id, Long sender);
    void delete(long id);
    List<Schedule> findAll();
    Schedule findById(Long id);
}
