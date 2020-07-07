package com.ats.remotetimemanager.Service.Attendance;

import com.ats.remotetimemanager.Controller.MarkAbsencesController;
import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.AttendanceRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "attendanceService")

public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MarkAbsencesController markAbsencesController;

    @Override
    public List<Attendance> findAll() {
        List<Attendance> list = new ArrayList<>();
        attendanceRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Attendance add(Attendance attendance) throws Exception {
        User userAtt =  userRepository.findByUserId(attendance.getUser().getUserId());
        String attType = attendance.getAttendanceType();
        if(
                userAtt.getAttendances().
                        stream().
                        noneMatch(
                                attendance1 -> attendance1.getAttendanceDate().compareTo(LocalDate.now()) == 0  && attendance1.getAttendanceType().equals(attType)))
        {
            attendance.setAttendanceDate(LocalDate.now().plusDays(1));
            markAbsencesController.markAbsence();
            return attendanceRepository.save(attendance);
        }
        return null;
    }

    @Override
    public Attendance update(Attendance attendance, Long id) {
        if(attendanceRepository.findById(id).isPresent()){
            Attendance newAtt = attendanceRepository.findById(id).get();
            newAtt.setAttendanceDate(attendance.getAttendanceDate());
            newAtt.setAttendanceType(attendance.getAttendanceType());
            newAtt.setInputType(attendance.getInputType());
            return attendanceRepository.save(newAtt);
        }else return null;

    }

    @Override
    public void delete(long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public Attendance findById(long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> findByUser(User user) {
        return attendanceRepository.findAllByUser(user);
    }
}
