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

    private String scheduleName;
    private String scheduleDescription;
    private int startHour;
    private int endHour;
    private String color;
    private String colorIcon;
    private Boolean pauseTime;
    private int pauseStart;
    private int pauseEnd;
    private boolean showSch;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @JsonIgnoreProperties(value ="schedule" , allowSetters = true)
    private List<Planning> plannings = new ArrayList<>() ;

    public Schedule() {
    }

    public Schedule(String scheduleName, String scheduleDescription, int startHour, int endHour, String color, String colorIcon, Boolean pauseTime, int pauseStart, int pauseEnd, boolean showSch) {
        this.scheduleName = scheduleName;
        this.scheduleDescription = scheduleDescription;
        this.startHour = startHour;
        this.endHour = endHour;
        this.color = color;
        this.colorIcon = colorIcon;
        this.pauseTime = pauseTime;
        this.pauseStart = pauseStart;
        this.pauseEnd = pauseEnd;
        this.showSch = showSch;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        this.scheduleDescription = scheduleDescription;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getColorIcon() {
        return colorIcon;
    }

    public void setColorIcon(String colorIcon) {
        this.colorIcon = colorIcon;
    }

    public boolean getShowSch() {
        return showSch;
    }

    public void setShowSch(boolean showSch) {
        this.showSch = showSch;
    }

    public boolean isShowSch() {
        return showSch;
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
                ", scheduleName='" + scheduleName + '\'' +
                ", scheduleDescription='" + scheduleDescription + '\'' +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", color='" + color + '\'' +
                ", colorIcon='" + colorIcon + '\'' +
                ", pauseTime=" + pauseTime +
                ", pauseStart=" + pauseStart +
                ", pauseEnd=" + pauseEnd +
                ", showSch=" + showSch +
                ", plannings=" + plannings +
                '}';
    }
}
