package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Repository.ScheduleRepository;
import com.ats.remotetimemanager.Service.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ScheduleSeeder{
    @Autowired
    private ScheduleRepository scheduleRepository;

    String weekDays[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"} ;
    Schedule normalTime = new Schedule(

            480,
            1020,
            true,
            720,
            840
    );
    String weekEnd[] = {"Saturday"} ;
    Schedule saturdayTime = new Schedule(
            480,
            780,
            false,
            0,
            0
    );
    Planning plan1 = new Planning(weekDays, "NORMAL TIME",
            "Normal time monday to friday",
            true,
            "btn btn-outline-success",
            "btn btn-success",5,"25-05-2020","05-06-2020");
    Planning plan2 = new Planning(weekEnd, "SATURDAY TIME",
            "only on saturday",
            false,
            "btn btn-outline-info",
            "btn btn-info",5,"25-05-2020","05-06-2020");

    public void seed(){
       if(scheduleRepository.findAll().isEmpty()){
           System.out.println(normalTime);
           System.out.println(saturdayTime);
           normalTime.setPlannings(Arrays.asList(plan1));
           scheduleRepository.save(normalTime);
           saturdayTime.setPlannings(Arrays.asList(plan2));
           scheduleRepository.save(saturdayTime);
       }
    }
}
