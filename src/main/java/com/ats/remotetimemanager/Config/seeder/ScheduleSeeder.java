package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Repository.ScheduleRepository;
import com.ats.remotetimemanager.Service.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleSeeder{
    @Autowired
    private ScheduleRepository scheduleRepository;

    String weekDays[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"} ;
    Schedule normalTime = new Schedule(
            "NORMAL TIME",
            "Normal time monday to friday",
            8,
            17,
            weekDays,
            5,
            "btn btn-success",
            "btn btn-outline-success",
            true,
            12,
            14,
            true
    );
    String weekEnd[] = {"Saturday"} ;
    Schedule saturdayTime = new Schedule(
            "SATURDAY TIME",
            "only on saturday",
            8,
            13,
            weekEnd,
            5,
            "btn btn-info",
            "btn btn-outline-info",
            false,
            0,
            0,
            false
    );

    public void seed(){
       if(scheduleRepository.findAll().isEmpty()){
           System.out.println(normalTime);
           System.out.println(saturdayTime);
           scheduleRepository.save(normalTime);
               scheduleRepository.save(saturdayTime);
       }
    }
}
