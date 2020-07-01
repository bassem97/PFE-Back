package com.ats.remotetimemanager.Service.Attendance;

import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> findAll() {
        List<Attendance> list = new ArrayList<>();
        attendanceRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Attendance add(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance update(Attendance attendance, Long id) {
        if(attendanceRepository.findById(id).isPresent()){
            Attendance newAtt = attendanceRepository.findById(id).get();
            newAtt.setAttendanceDate(attendance.getAttendanceDate());
            newAtt.setAttendanceTime(attendance.getAttendanceTime());
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
