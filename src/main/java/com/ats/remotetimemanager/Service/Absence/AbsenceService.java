package com.ats.remotetimemanager.Service.Absence;

import com.ats.remotetimemanager.Model.Absence;

import java.util.List;

public interface AbsenceService {
    Absence update(Absence absence, Long id);
    Absence add(Absence absence);
    void delete(long id);
    List<Absence> findAll();
}
