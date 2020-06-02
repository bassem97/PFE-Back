package com.ats.remotetimemanager.Service.Planning;

import com.ats.remotetimemanager.Model.Planning;
import com.ats.remotetimemanager.Repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "planningService")
public class PlanningServiceImpl implements PlanningService {

    @Autowired
    PlanningRepository planningRepository;

    @Override
    public Planning add(Planning planning) {
        return planningRepository.save(planning);    }

    @Override
    public Planning update(Planning planning, Long id) {
        if(planningRepository.findById(id).isPresent()){
            Planning plan= planningRepository.findByPlanningId(id);
            plan.setPlanningId(planning.getPlanningId());
            plan.setStartDate(planning.getStartDate());
            plan.setEndDate(planning.getEndDate());
            plan.setRepeatCycle(plan.getRepeatCycle());
            plan.setScheduleDays(planning.getScheduleDays());
            plan.setSchedule(planning.getSchedule());
            return planningRepository.save(plan);
        }else return null;
    }

    @Override
    public void delete(long id) {
        planningRepository.deleteById(id);
    }

    @Override
    public List<Planning> findAll() {
        return planningRepository.findAll();
    }

    @Override
    public Planning findById(Long id) {
        return planningRepository.findByPlanningId(id);
    }
}
