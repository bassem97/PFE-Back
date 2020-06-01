package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Planning {

    @Id
    @Column(name= "planning_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planningId;

    private String[] scheduleDays;

    private String startDate;
    private String endDate;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "schedule_id")
    @JsonIgnoreProperties(value ={"plannings"} , allowSetters = true)
    private Schedule schedule;

    public Planning() {
    }

    public Planning(String[] scheduleDays, String startDate, String endDate) {
        this.scheduleDays = scheduleDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getPlanningId() {
        return planningId;
    }

    public void setPlanningId(Long planningId) {
        this.planningId = planningId;
    }

    public String[] getScheduleDays() {
        return scheduleDays;
    }

    public void setScheduleDays(String[] scheduleDays) {
        this.scheduleDays = scheduleDays;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "PlanningId=" + planningId +
                ", scheduleDays=" + Arrays.toString(scheduleDays) +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
