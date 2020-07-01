package com.ats.remotetimemanager.Service.Absence;

import com.ats.remotetimemanager.Model.Absence;

import java.util.List;

public interface AbsenceService {
    Absence update(Absence absence, Long id);
    void delete(long id);
    List<Absence> findAll();
}
