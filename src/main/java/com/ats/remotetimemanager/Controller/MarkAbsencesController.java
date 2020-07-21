package com.ats.remotetimemanager.Controller;


import com.ats.remotetimemanager.Model.*;
import com.ats.remotetimemanager.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
@RequestMapping("/absence/")
@Configuration
@EnableScheduling
public class MarkAbsencesController {
    public Boolean reloadSocket = true;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PlanningRepository planningRepository;

    @Autowired
    PlanningConfigRepository planningConfigRepository;

    @Autowired
    AbsenceRepository absenceRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private WebSocketController webSocketController;

    @Autowired
    private AbsenceController absenceController;

    @RequestMapping("markAbsences")
    public void markFromRequest() throws Exception {
        reloadSocket = false;
        markAbsence();
    }

            @Scheduled(cron = "0 */30 * * * *") // every 30mn
//    @Scheduled(cron = "*/60 * * * * *") // every 30 seconds
    public boolean markAbsence() throws Exception {
        try {
            List<User> users = userRepository.findAll()
                    .stream()
                    .filter(user -> Arrays.asList(user.getDepartment().getPlanning().getScheduleDays()).contains(LocalDate.now().getDayOfWeek().toString().toUpperCase()))
                    .collect(Collectors.toList());
            users.forEach(user -> {
                user.setAbsences(absenceRepository.findAllByUser(user));
                user.setAttendances(attendanceRepository.findAllByUser(user));
                 user.getDepartment().getPlanning().setPlanningConfigs(planningConfigRepository.findAllByPlanning(user.getDepartment().getPlanning()));
                List<Absence> abs = new ArrayList<>();
                if (!user.getAbsences().isEmpty()) {
                    user.getAbsences().forEach(absence -> {
                        if (absence.getAbsenceDate().compareTo(LocalDate.now()) == 0) {
                            abs.add(absence);
                        }
                    });
                }
                User newUser = new User();
                newUser.setAbsences(abs);
                newUser.setAttendances(user.getAttendances());
                newUser.setUserId(user.getUserId());
                newUser.setDepartment(user.getDepartment());
                getStatus("CHECK IN", newUser);
                getStatus("CHECK OUT", newUser);
            });
        } finally {
        if (reloadSocket) {
            webSocketController.sendMessage(new WebSocketMessage("att"));
        }
            reloadSocket = true;
        }
        return true;
    }

    private void getStatus(String type, User emp) {

        AtomicReference<Boolean> noCheckIn = new AtomicReference<>(true);
        List<String> types = new ArrayList<>();
        if (!emp.getAbsences().isEmpty()) {
            if (!emp.getAbsences().isEmpty()) {
                emp.getAbsences().forEach(absence -> {
                    types.add(absence.getAbsenceType());
                });
            }
        }
        int endHour = emp.getDepartment().getPlanning().getSchedule().getEndHour();
        int startHour = emp.getDepartment().getPlanning().getSchedule().getStartHour();
        int checkInDelay = emp.getDepartment().getPlanning().getPlanningConfigs().get(0).getCheckInDelay();
        int checkOutDelay = emp.getDepartment().getPlanning().getPlanningConfigs().get(0).getCheckOutDelay();
        int endCheckIn = emp.getDepartment().getPlanning().getPlanningConfigs().get(0).getEndCheckin();
        int absentMinutes = 0;
        absentMinutes = endHour - startHour;
        if (emp.getDepartment().getPlanning().getSchedule().getPauseTime()) {
            absentMinutes = absentMinutes - (emp.getDepartment().getPlanning().getSchedule().getPauseEnd() - emp.getDepartment().getPlanning().getSchedule().getPauseStart());
        }
        if (type.equals("CHECK OUT")) {
            emp.getAttendances().forEach(att -> {
                if (att.getAttendanceType().equals("CHECK OUT")) {
                    noCheckIn.set(false);
                    if ((endHour - checkOutDelay) - att.getAttendanceTime() > 0) {

                       // creating early check-out absence
                        if (!types.isEmpty()) {
                            if (!types.contains("Early check-out") && !types.contains("All day")) {
                                try {
                                    createAbsence(emp, "Early check-out", ((endHour - checkOutDelay) - att.getAttendanceTime()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                createAbsence(emp, "Early check-out", ((endHour - checkOutDelay) - att.getAttendanceTime()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return;
                }
            });
        } else {
            int finalAbsentMinutes = absentMinutes;
            emp.getAttendances().forEach(att -> {
                if (att.getAttendanceType().equals("CHECK IN")) {
                    if (((startHour + checkInDelay) - att.getAttendanceTime()) >= 0) {
                        noCheckIn.set(false);
                        return;
                    } else if (((startHour - checkInDelay) - att.getAttendanceTime()) < 0 && att.getAttendanceTime() <= startHour + endCheckIn) {
                        noCheckIn.set(false);
                        if (!types.isEmpty()) {
                            if (!types.contains("Late check-in") && !types.contains("All day")) {
                                try {
                                    createAbsence(emp, "Late check-in", (att.getAttendanceTime() - (startHour + checkInDelay)));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                createAbsence(emp, "Late check-in", (att.getAttendanceTime() - (startHour + checkInDelay)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (att.getAttendanceTime() > endCheckIn + startHour) {
                    noCheckIn.set(false);
                    if (!types.isEmpty()) {
                        if (!types.contains("All day")) {
                            try {
                                createAbsence(emp, "All day", finalAbsentMinutes);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            createAbsence(emp, "All day", finalAbsentMinutes);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                }
                return;
            });
            if (noCheckIn.get()) {
                Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
                Date date = new Date();
                calendar.setTime(date);
                int minutes = (calendar.get(Calendar.HOUR_OF_DAY) * 60) + calendar.get(Calendar.MINUTE);
                if (minutes > (startHour + checkInDelay) && minutes <= (startHour + endCheckIn)) {
                    return;
                } else if (minutes > (startHour + checkInDelay)) {
                    if (!types.isEmpty()) {
                        if (!types.contains("All day")) {
                            try {
                                createAbsence(emp, "All day", finalAbsentMinutes);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            createAbsence(emp, "All day", finalAbsentMinutes);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private void createAbsence(User emp, String type, int minutes) throws Exception {
        if (type.equals("All day") && !emp.getAbsences().isEmpty()) {
            emp.getAbsences().forEach(absence -> {
                this.absenceRepository.deleteById(absence.getIdAbsence());
            });
        }
        Absence absence = new Absence();
        absence.setUser(emp);
        absence.setAbsentMinutes(minutes);
        absence.setAbsenceDate(LocalDate.now());
        absence.setAbsenceType(type);
        absenceController.add(absence);
    }
}
