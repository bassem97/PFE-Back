package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Repository.AttendanceRepository;
import com.ats.remotetimemanager.Repository.AttendanceRepository;
import com.ats.remotetimemanager.Service.Attendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/att/")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("list")
    public List<Attendance> getAll() {
        return attendanceService.findAll();
    }

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    WebSocketController webSocketController;

    @PostMapping("add")
    public Attendance add(@Valid @RequestBody Attendance attendance) throws Exception {
        Attendance att =  attendanceService.add(attendance);
        if(att != null)
        webSocketController.sendMessage(new WebSocketMessage("att"));
        return att;
    }

    @PutMapping("update/{id}")
    public Attendance update(@Valid @RequestBody Attendance attendance,@PathVariable("id") Long id){
        return attendanceService.update(attendance, id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id){
        attendanceService.delete(id);
    }

    @GetMapping("findById/{id}")
    public Attendance findById(@PathVariable("id") long id){
        return attendanceService.findById(id);
    }

    @GetMapping("findByUser")
    public List<Attendance> findByUser(@Valid @RequestBody User user){
        return attendanceService.findByUser(user);
    }

    @GetMapping("find")
    public List<Attendance> get(@RequestBody User user){
        return attendanceRepository.findAllByUser(user)
                .stream()
                .filter(attendance -> attendance.getAttendanceDate().compareTo(LocalDate.now()) == 0)
                .collect(Collectors.toList());
    }
}
