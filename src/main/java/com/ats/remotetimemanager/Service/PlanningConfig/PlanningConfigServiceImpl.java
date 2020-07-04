package com.ats.remotetimemanager.Service.PlanningConfig;

import com.ats.remotetimemanager.Model.PlanningConfig;
import com.ats.remotetimemanager.Repository.PlanningConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("planningConfigService")
public class PlanningConfigServiceImpl implements PlanningConfigService {

    @Autowired
    PlanningConfigRepository planningConfigRepository;

    @Override
    public PlanningConfig add(PlanningConfig planningConfig) {
        return planningConfigRepository.save(planningConfig);
    }

    @Override
    public PlanningConfig update(PlanningConfig planningConfig, Long id) {
        if(planningConfigRepository.findById(id).isPresent()){
            PlanningConfig newPlanConfig = planningConfigRepository.findById(id).get();
            newPlanConfig.setCheckInDelay(planningConfig.getCheckInDelay());
            newPlanConfig.setCheckOutDelay(planningConfig.getCheckOutDelay());
            newPlanConfig.setEndCheckin(planningConfig.getEndCheckin());
            return planningConfigRepository.save(newPlanConfig);
        }
        return null;
    }
}
