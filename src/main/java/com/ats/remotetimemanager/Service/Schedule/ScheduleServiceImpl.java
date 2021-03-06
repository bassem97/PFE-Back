package com.ats.remotetimemanager.Service.Schedule;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Repository.PlanningConfigRepository;
import com.ats.remotetimemanager.Repository.PlanningRepository;
import com.ats.remotetimemanager.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PlanningRepository planningRepository;

    @Autowired
    PlanningConfigRepository planningConfigRepository;


    @Override
    public Schedule add(Schedule schedule) {
       return  scheduleRepository.save(schedule) ;
    }

    @Override
    public Schedule update(Schedule schedule, Long id,Long sender ) {
        if (scheduleRepository.findById(id).isPresent()) {
            Schedule sch = scheduleRepository.findByScheduleId(id);
            sch.setStartHour(schedule.getStartHour());
            sch.setEndHour(schedule.getEndHour());
            sch.setPauseTime(schedule.getPauseTime());
            sch.setPauseStart(schedule.getPauseStart());
            sch.setPauseEnd(schedule.getPauseEnd());
            if (sender == 1) {
                schedule.getPlannings().forEach(planning -> {
                    if (planning.getPlanningId() != null) {
                        if (planningRepository.findById(planning.getPlanningId()).isPresent()) {
                            planning.getPlanningConfigs().clear();
                            planning.setPlanningConfigs(planningConfigRepository.findAllByPlanning(planning));
                        }
                    }
                });
                sch.setPlannings(schedule.getPlannings());
            }
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
    public Schedule findById(Long id) {
        return scheduleRepository.findByScheduleId(id);
    }


}
