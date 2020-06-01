package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Planning;
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

    @GetMapping("list")
    public List<Planning> getAll() { return planningService.findAll() ;}

    @PostMapping("add")
    public Planning add(@RequestBody Planning planning) {
        return planningService.add(planning);}

    @PutMapping("update/{id}")
    public Planning update(@Valid @RequestBody Planning planning, @PathVariable("id") Long id){
        return planningService.update(planning,id);}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) { planningService.delete(id);}

    @GetMapping("findById/{id}")
    public Planning findById(@PathVariable("id") Long id) {return planningService.findById(id) ;}
}
