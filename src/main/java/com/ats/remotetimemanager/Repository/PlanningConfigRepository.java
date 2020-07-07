package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.PlanningConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningConfigRepository extends JpaRepository<PlanningConfig,Long> {
    List<PlanningConfig> findAllByPlanning(Planning planning);
}
