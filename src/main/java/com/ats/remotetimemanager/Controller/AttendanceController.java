package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Service.Attendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

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

    @PostMapping("add")
    public Attendance add(@Valid @RequestBody Attendance attendance) {
        return attendanceService.add(attendance);
    }

    @PutMapping("update/{id}")
    Attendance update(@Valid @RequestBody Attendance attendance, @PathVariable("id") Long id) {
        return attendanceService.update(attendance, id);
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable("id") long id) {
        attendanceService.delete(id);
    }

    @GetMapping("findById/{id}")
    Attendance findById(@PathVariable("id") long id) {
        return attendanceService.findById(id);
    }

    @GetMapping("findByUser")
    public List<Attendance> findByUser(User user) {
        return attendanceService.findByUser(user);
    }

    @GetMapping("findByUserAndDate")
    public List<Attendance> findAttendancesByUser(@Valid @RequestBody User user) {
        return attendanceService.findAttendancesByUser(user);
    }

}
