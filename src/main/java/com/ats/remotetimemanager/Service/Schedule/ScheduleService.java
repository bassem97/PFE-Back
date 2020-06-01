package com.ats.remotetimemanager.Service.Schedule;

import com.ats.remotetimemanager.Model.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule add(Schedule schedule);
    Schedule update(Schedule schedule, Long id);
    void delete(long id);
    List<Schedule> findAll();
    Schedule findByName(String name);
    Schedule findById(Long id);
}
