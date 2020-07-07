package com.ats.remotetimemanager.Controller;


import com.ats.remotetimemanager.Model.*;
import com.ats.remotetimemanager.Repository.AbsenceRepository;
import com.ats.remotetimemanager.Repository.NotificationMessageRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.Absence.AbsenceService;
import com.ats.remotetimemanager.Service.Notification.NotificationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/absence/")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationMessageRepository notificationMessageRepository;

    @Autowired
    WebSocketController webSocketController;

    @Autowired
    private NotificationMessageService notificationMessageService;

    @PutMapping("update/{id}")
    public Absence update(@Valid @RequestBody Absence absence, @PathVariable("id") Long id) throws Exception {
        Absence abs = absenceService.update(absence,id);
        NotificationMessage notif ;
        User user = userRepository.findByUserId(absenceRepository.findById(id).get().getUser().getUserId());
        if (absence.getReasonStatus().equals("btn btn-warning")) {
            Department department = userRepository.findByUserId(absenceRepository.findById(id).get().getUser().getUserId()).getDepartment();
            List<NotificationMessage> notifs = new ArrayList<>();
            for (User us : userRepository.findAll()) {
                if((us.isAdmin() || us.getUserId() == department.getChefDep()) && us.getUserId() != user.getUserId()){
                    notif = new NotificationMessage("Absence reason"
                            ,user.getName()+" "+user.getFirstName()+" has provided a reason for "+abs.getAbsenceDate()+" absence"
                            , new Date(), false, false, us);
                    notifs.add(notif);
                }
            }
            notificationMessageService.saveAll(notifs);
        } else {
            String reasonStatus = abs.getReasonStatus().equals("btn btn-success") ? "accepted" : "rejected";
            notif = new NotificationMessage("Absence "
                ,"Your provided reason for "+abs.getAbsenceDate()+" has been "+reasonStatus+" by "+abs.getRevisedBy()
                , new Date(), false, false, user);

            notificationMessageRepository.save(notif);
        }
        webSocketController.sendMessage(new WebSocketMessage("absence"));
        return abs;
    }
    @PutMapping("add")
    Absence add(@Valid @RequestBody Absence absence) throws Exception {
        String notifMsg = "";
        String notifTitle = "";
        if (absence.getAbsenceType().equals("All day")) {
            notifMsg = "You have been marked absent ("+absence.getAbsenceDate()+")";
            notifTitle = "Absent";
        } else if (absence.getAbsenceType().equals("Early check-out")) {
            notifMsg = "Early check-out at "+absence.getAbsenceDate()+" marked.";
            notifTitle = "Early check-out";
        } else if (absence.getAbsenceType().equals("Late check-in")) {
            notifMsg = "Late check-in at " + absence.getAbsenceDate() + " marked.";
            notifTitle = "Late check-in";
        }
            NotificationMessage notif = new NotificationMessage(notifTitle
                , notifMsg, new Date(), false, false, userRepository.findByUserId(absence.getUser().getUserId()));
        notificationMessageRepository.save(notif);
        webSocketController.sendMessage(new WebSocketMessage("absence"));
        return  absenceService.add(absence);

    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id){
        absenceService.delete(id);
    }

    @GetMapping("list")
    public List<Absence> findAll(){
        return absenceService.findAll();
    }

    @GetMapping("listByUser/{id}")
    List<Absence> listByUser(@PathVariable("id") Long id){
        return absenceRepository.findAllByUser(userRepository.findByUserId(id));
    }
}
