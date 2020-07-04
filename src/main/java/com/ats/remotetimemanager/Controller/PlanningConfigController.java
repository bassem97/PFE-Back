package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.PlanningConfig;
import com.ats.remotetimemanager.Service.Planning.PlanningService;
import com.ats.remotetimemanager.Service.PlanningConfig.PlanningConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/planningConfig/")
public class PlanningConfigController {

    @Autowired
    PlanningConfigService planningConfigService;

    @PostMapping("add")
    public PlanningConfig add(@RequestBody @Valid PlanningConfig planningConfig) {
        return planningConfigService.add(planningConfig);
    }

    @PutMapping("update/{id}")
    public PlanningConfig update(@RequestBody @Valid PlanningConfig planningConfig, @PathVariable("id") Long id){
        return planningConfigService.update(planningConfig,id);
    }
}
