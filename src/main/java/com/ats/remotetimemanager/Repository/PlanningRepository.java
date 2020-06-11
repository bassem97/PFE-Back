package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends JpaRepository<Planning,Long> {
    Planning findByPlanningId(long id);
}
