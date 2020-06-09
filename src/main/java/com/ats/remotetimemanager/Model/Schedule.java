package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "SCHEDULES")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private long scheduleId;

   private int startHour;
    private int endHour;
    private Boolean pauseTime;
    private int pauseStart;
    private int pauseEnd;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @JsonIgnoreProperties(value ="schedule" , allowSetters = true)
    private List<Planning> plannings = new ArrayList<>() ;

    public Schedule() {
    }

    public Schedule(int startHour, int endHour, Boolean pauseTime, int pauseStart, int pauseEnd) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.pauseTime = pauseTime;
        this.pauseStart = pauseStart;
        this.pauseEnd = pauseEnd;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public Boolean getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(Boolean pauseTime) {
        this.pauseTime = pauseTime;
    }

    public int getPauseStart() {
        return pauseStart;
    }

    public void setPauseStart(int pauseStart) {
        this.pauseStart = pauseStart;
    }

    public int getPauseEnd() {
        return pauseEnd;
    }

    public void setPauseEnd(int pauseEnd) {
        this.pauseEnd = pauseEnd;
    }


    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", pauseTime=" + pauseTime +
                ", pauseStart=" + pauseStart +
                ", pauseEnd=" + pauseEnd +
                ", plannings=" + plannings +
                '}';
    }
}
