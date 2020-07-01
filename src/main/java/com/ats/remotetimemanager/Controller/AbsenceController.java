package com.ats.remotetimemanager.Controller;


import com.ats.remotetimemanager.Model.Absence;
import com.ats.remotetimemanager.Service.Absence.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/absence/")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PutMapping("update/{id}")
    Absence update(@Valid @RequestBody Absence absence, @PathVariable("id") Long id){
        return absenceService.update(absence,id);
    }

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable("id") long id){
        absenceService.delete(id);
    }
    @GetMapping("list")
    List<Absence> findAll(){
        return absenceService.findAll();
    }
}
