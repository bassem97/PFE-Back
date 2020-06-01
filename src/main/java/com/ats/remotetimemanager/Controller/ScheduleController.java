package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Service.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/schedule/")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("list")
    public List<Schedule> getAll() { return scheduleService.findAll() ;}

    @PostMapping("add")
    public Schedule add(@RequestBody Schedule schedule) {
        return scheduleService.add(schedule);}

    @PutMapping("update/{id}")
    public Schedule update(@Valid @RequestBody Schedule schedule, @PathVariable("id") Long id){
        return scheduleService.update(schedule,id);}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) { scheduleService.delete(id);}

    @GetMapping("findById/{id}")
    public Schedule findById(@PathVariable("id") Long id) {return scheduleService.findById(id) ;}
}
