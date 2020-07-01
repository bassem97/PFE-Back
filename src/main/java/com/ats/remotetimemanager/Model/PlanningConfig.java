package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class PlanningConfig {
    @Id
    @Column(name= "planning_configurations_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlanConfigId;

    private int checkInDelay;
    private int checkOutDelay;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "planning_id")
    @JsonIgnoreProperties(value ={"planningConfigs"} , allowSetters = true)
    private Planning planning;




    public PlanningConfig(int checkInDelay, int checkOutDelay) {
        this.checkInDelay = checkInDelay;
        this.checkOutDelay = checkOutDelay;
    }

    public Long getPlanConfigId() {
        return PlanConfigId;
    }

    public void setPlanConfigId(Long planConfigId) {
        PlanConfigId = planConfigId;
    }

    public int getCheckInDelay() {
        return checkInDelay;
    }

    public void setCheckInDelay(int checkInDelay) {
        this.checkInDelay = checkInDelay;
    }

    public int getCheckOutDelay() {
        return checkOutDelay;
    }

    public void setCheckOutDelay(int checkOutDelay) {
        this.checkOutDelay = checkOutDelay;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
}
