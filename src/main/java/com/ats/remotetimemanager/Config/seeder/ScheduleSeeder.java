package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Repository.ScheduleRepository;
import com.ats.remotetimemanager.Service.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            "btn btn-success",5,"2020-06-20T23:00:00.000Z","2020-06-25T23:00:00.000Z");
    Planning plan2 = new Planning(weekEnd, "SATURDAY TIME",
            "only on saturday",
            false,
            "btn btn-outline-info",
            "btn btn-info",5,"2020-06-20T23:00:00.000Z","2020-06-30T23:00:00.000Z");
    Planning plan3 = new Planning(weekEnd, "SATURDAY TIME",
            "only on saturday",
            true,
            "btn btn-outline-dark",
            "btn btn-dark",2,"2020-06-20T23:00:00.000Z","2020-07-10T23:00:00.000Z");
    Planning plan4 = new Planning(weekEnd, "NORMAL TIME",
            "Normal time monday to friday",
            false,
            "btn btn-outline-danger",
            "btn btn-danger",2,"2020-06-20T23:00:00.000Z","2020-07-30T23:00:00.000Z");

    public void seed(){
       if(scheduleRepository.findAll().isEmpty()){
           System.out.println(normalTime);
           System.out.println(saturdayTime);
           List<Planning> l1 = new ArrayList<>();
           List<Planning> l2 = new ArrayList<>();
           l1.add(plan1);
           l1.add(plan2);
           l2.add(plan3);
           l2.add(plan4);
           normalTime.setPlannings(l1);
           scheduleRepository.save(normalTime);
           saturdayTime.setPlannings(l2);
           scheduleRepository.save(saturdayTime);
       }
    }
}
