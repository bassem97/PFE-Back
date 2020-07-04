package com.ats.remotetimemanager.Service.PlanningConfig;

import com.ats.remotetimemanager.Model.PlanningConfig;

public interface PlanningConfigService {
    PlanningConfig add(PlanningConfig planningConfig);
    PlanningConfig update(PlanningConfig planningConfig, Long id);
}
