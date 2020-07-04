package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.PlanningConfig;
import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.ScheduleRepository;
import com.ats.remotetimemanager.Service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ScheduleSeeder{
    @Autowired
    private ScheduleRepository scheduleRepository;

    private final Path root = Paths.get("Images");

    @Autowired
    private DepartmentRepository departmentRepository ;

    @Autowired
    private DepartmentService departmentService;

    String weekDays[] = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"} ;
    Schedule normalTime = new Schedule(

            480,
            1020,
            true,
            720,
            840
    );
    String weekEnd[] = {"SATURDAY"} ;
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

    Department mark = new Department("marketing", null, plan4);
    Department info = new Department("informatique", null, plan1);
    Department security = new Department("security", info, plan2);
    Department khra = new Department("Resources humaines", security, plan3);

    public void seed(){
       if(scheduleRepository.findAll().isEmpty()){
           try {
               if(!Files.exists(root)) Files.createDirectory(root);
           } catch (IOException e) {
               e.printStackTrace();
           }

           plan1.setPlanningConfigs(Arrays.asList(new PlanningConfig(5,15,540)));
           plan2.setPlanningConfigs(Arrays.asList(new PlanningConfig(10,10,540)));
           plan3.setPlanningConfigs(Arrays.asList(new PlanningConfig(30,30,540)));
           plan4.setPlanningConfigs(Arrays.asList(new PlanningConfig(5,5,540)));
           List<Planning> l1 = new ArrayList<>();
           List<Planning> l2 = new ArrayList<>();
           plan1.setSchedule(normalTime);
           l1.add(plan1);
           l1.add(plan2);
           l2.add(plan3);
           l2.add(plan4);
           normalTime.setPlannings(l1);
           scheduleRepository.save(normalTime);
           saturdayTime.setPlannings(l2);
           scheduleRepository.save(saturdayTime);

           if(departmentRepository.findAll().isEmpty()){
               departmentService.add(info);
               departmentService.add(security );
               departmentService.add(khra);
               departmentService.add(mark);
           }

       }
    }
}
