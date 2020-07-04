package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.PlanningConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningConfigRepository extends JpaRepository<PlanningConfig,Long> {
}
