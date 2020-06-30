package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.WebSocketMessage;
import com.ats.remotetimemanager.Service.Planning.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/planning/")
public class PlanningController {
    @Autowired
    private PlanningService planningService;

    @Autowired
    private WebSocketController webSocketController;

    @GetMapping("list")
    public List<Planning> getAll() { return planningService.findAll() ;}

    @PostMapping("add")
    public Planning add(@RequestBody Planning planning) throws Exception {
        Planning pl3 = planningService.add(planning);
        webSocketController.sendMessage(new WebSocketMessage("timetable"));
        return pl3;
    }

    @PutMapping("update/{id}/{sender}")
    public Planning update(@Valid @RequestBody Planning planning, @PathVariable("id") Long id, @PathVariable("sender") Long sender) throws Exception {
        Planning pl3 = planningService.update(planning,id);
        if (sender != 2) {
            webSocketController.sendMessage(new WebSocketMessage("timetable"));
        }
        return pl3;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        planningService.delete(id);
        webSocketController.sendMessage(new WebSocketMessage("timetable"));
    }

    @GetMapping("findById/{id}")
    public Planning findById(@PathVariable("id") Long id) {return planningService.findById(id) ;}
}
