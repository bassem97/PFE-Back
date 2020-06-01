package com.ats.remotetimemanager.Service.Schedule;

import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule add(Schedule schedule) {
        return schedule.getScheduleId() != 0 ? scheduleRepository.save(schedule) : null;
    }

    @Override
    public Schedule update(Schedule schedule, Long id) {
        if (scheduleRepository.findById(id).isPresent()) {
            Schedule sch = scheduleRepository.findByScheduleId(id);
            sch.setScheduleName(schedule.getScheduleName());
            sch.setScheduleDescription(schedule.getScheduleDescription());
            sch.setScheduleDays(schedule.getScheduleDays());
            sch.setColor(schedule.getColor());
            sch.setStartHour(schedule.getStartHour());
            sch.setEndHour(schedule.getEndHour());
            sch.setPauseTime(schedule.getPauseTime());
            sch.setPauseStart(schedule.getPauseStart());
            sch.setPauseEnd(schedule.getPauseEnd());
            sch.setRepeatCycle(schedule.getRepeatCycle());
            sch.setColorIcon(schedule.getColorIcon());
            sch.setShowSch(schedule.getShowSch());
            return scheduleRepository.save(sch);
        }else return null;
    }

    @Override
    public void delete(long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findByName(String name) {
        return scheduleRepository.findByScheduleName(name);
    }

    @Override
    public Schedule findById(Long id) {
        return scheduleRepository.findByScheduleId(id);
    }
}
