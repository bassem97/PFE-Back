package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;

@Entity
@Configuration
@EnableScheduling
public class PlanningConfig {
    @Id
    @Column(name= "planning_configurations_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlanConfigId;

    private int checkInDelay;
    private int checkOutDelay;
    private int endCheckin;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "planning_id")
    @JsonIgnoreProperties(value ={"planningConfigs"} , allowSetters = true)
    private Planning planning;


    public PlanningConfig() {
    }

    public PlanningConfig(int checkInDelay, int checkOutDelay, int endCheckin) {
        this.checkInDelay = checkInDelay;
        this.checkOutDelay = checkOutDelay;
        this.endCheckin = endCheckin;
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

    public int getEndCheckin() {
        return endCheckin;
    }

    public void setEndCheckin(int endCheckin) {
        this.endCheckin = endCheckin;
    }




    @Override
    public String toString() {
        return "PlanningConfig{" +
                "PlanConfigId=" + PlanConfigId +
                ", checkInDelay=" + checkInDelay +
                ", checkOutDelay=" + checkOutDelay +
                ", planning=" + planning +
                '}';
    }
}
