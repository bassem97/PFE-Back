package com.ats.remotetimemanager.Service.Attendance;

import com.ats.remotetimemanager.Model.Attendance;
import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Attendance> findAttendancesByUser(User user) {
        System.out.println("_______________________________________________________");
        System.out.println(attendanceRepository.findAttendancesByUser(user).stream()
                .filter(attendance -> (attendance.getAttendanceDate().compareTo(LocalDate.now().plusDays(1))) == 0 )
                .collect(Collectors.toList()));
        System.out.println("_______________________________________________________");
        return  attendanceRepository.findAttendancesByUser(user).stream()
                .filter(attendance -> (attendance.getAttendanceDate().compareTo(LocalDate.now().plusDays(1))) == 0 )
                .collect(Collectors.toList());

//        for (int i = 0; i< atts.size(); i++) {
//            if (atts.get(i).getAttendanceDate() != (LocalDate.now().plusDays(1))) {
//                atts.remove(i);
//            }
//        };
    }
}
