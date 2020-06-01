package com.ats.remotetimemanager.Service.Planning;

import com.ats.remotetimemanager.Model.Planning;

import java.util.List;

public interface PlanningService {
    Planning add(Planning planning);
    Planning update(Planning planning, Long id);
    void delete(long id);
    List<Planning> findAll();
    Planning findById(Long id);
}
