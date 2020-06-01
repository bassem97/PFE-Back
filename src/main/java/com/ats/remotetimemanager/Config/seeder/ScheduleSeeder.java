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
            "NORMAL TIME",
            "Normal time monday to friday",
            8,
            17,
            5,
            "#1AAA56",
            "green",
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
            5,
            "#0A4422",
            "green ghame9",
            false,
            0,
            0,
            false
    );
    Planning plan1 = new Planning(weekDays,"25-05-2020","05-06-2020");
    Planning plan2 = new Planning(weekEnd,"25-05-2020","05-06-2020");

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
