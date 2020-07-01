package com.ats.remotetimemanager.Service.Absence;

import com.ats.remotetimemanager.Model.Absence;
import com.ats.remotetimemanager.Repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "absenceService")
public class AbsenceServiceImpl implements AbsenceService{

    @Autowired
    private AbsenceRepository absenceRepository;

    @Override
    public Absence update(Absence absence, Long id) {
        if(absenceRepository.findById(id).isPresent()){
            Absence newAbsence = absenceRepository.findById(id).get();
            newAbsence.setAbsenceDate(absence.getAbsenceDate());
            newAbsence.setAbsenceType(absence.getAbsenceType());
            newAbsence.setAbsentMinutes(absence.getAbsentMinutes());
            newAbsence.setReason(absence.getReason());
            return absenceRepository.save(newAbsence);
        }else return null;
    }

    @Override
    public void delete(long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }
}
