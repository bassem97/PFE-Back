package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Schedule;
import com.ats.remotetimemanager.Model.WebSocketMessage;
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

    @Autowired
    private WebSocketController webSocketController;
    @GetMapping("list")
    public List<Schedule> getAll() { return scheduleService.findAll() ;}

    @PostMapping("add")
    public Schedule add(@RequestBody Schedule schedule) throws Exception {
        Schedule sch3 = scheduleService.add(schedule);
        webSocketController.sendMessage(new WebSocketMessage("timetable"));
        return sch3;
    }

    @PutMapping("update/{id}/{sender}")
    public Schedule update(@Valid @RequestBody Schedule schedule, @PathVariable("id") Long id, @PathVariable("sender") Long sender) throws Exception {
        Schedule sch3 = scheduleService.update(schedule,id, sender);
        webSocketController.sendMessage(new WebSocketMessage("timetable"));
        return sch3;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        scheduleService.delete(id);
        webSocketController.sendMessage(new WebSocketMessage("timetable"));
    }

    @GetMapping("findById/{id}")
    public Schedule findById(@PathVariable("id") Long id) {return scheduleService.findById(id) ;}
}
