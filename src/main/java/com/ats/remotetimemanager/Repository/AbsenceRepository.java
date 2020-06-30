package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
}
