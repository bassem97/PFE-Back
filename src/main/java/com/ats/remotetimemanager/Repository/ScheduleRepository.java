package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    Schedule findByScheduleId(Long id);
    Schedule findByPlanningsContains(Planning planning);
}
