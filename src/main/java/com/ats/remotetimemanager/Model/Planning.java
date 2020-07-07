package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Planning {

    @Id
    @Column(name= "planning_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planningId;

    private String[] scheduleDays;
    private String planningName;
    private String planningDescription;
    private boolean showPl;
    private int repeatCycle;
    private String startDate;
    private String endDate;
    private String color;
    private String colorIcon;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "schedule_id")
    @JsonIgnoreProperties(value ={"plannings"} , allowSetters = true)
    private Schedule schedule;

    @OneToMany(cascade =  {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "planning_Id")
    @JsonIgnoreProperties(value ={"planning"} , allowSetters = true)
    private List<Department> departments = new ArrayList<>() ;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "planning_id")
    @JsonIgnoreProperties(value ="planning" , allowSetters = true)
    private List<PlanningConfig> planningConfigs = new ArrayList<>() ;



    public Planning() {
    }

    public Planning(String[] scheduleDays, String planningName, String planningDescription, boolean showPl, String colorIcon, String color, int repeatCycle, String startDate, String endDate) {
        this.scheduleDays = scheduleDays;
        this.planningName = planningName;
        this.planningDescription = planningDescription;
        this.showPl = showPl;
        this.color = color;
        this.colorIcon = colorIcon;
        this.repeatCycle = repeatCycle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getPlanningId() {
        return planningId;
    }

    public void setPlanningId(Long planningId) {
        this.planningId = planningId;
    }

    public String getPlanningName() {
        return planningName;
    }

    public void setPlanningName(String planningName) {
        this.planningName = planningName;
    }

    public String getPlanningDescription() {
        return planningDescription;
    }

    public void setPlanningDescription(String planningDescription) {
        this.planningDescription = planningDescription;
    }

    public boolean getShowPl() {
        return showPl;
    }

    public void setShowPl(boolean showPl) {
        this.showPl = showPl;
    }

    public String getColorIcon() {
        return colorIcon;
    }

    public void setColorIcon(String colorIcon) {
        this.colorIcon = colorIcon;
    }

    public boolean isShowPl() {
        return showPl;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getRepeatCycle() {
        return repeatCycle;
    }

    public void setRepeatCycle(int repeatCycle) {
        this.repeatCycle = repeatCycle;
    }

    public List<PlanningConfig> getPlanningConfigs() {
        return planningConfigs;
    }

    public void setPlanningConfigs(List<PlanningConfig> planningConfigs) {
        this.planningConfigs = planningConfigs;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "planningId=" + planningId +
//                ", scheduleDays=" + Arrays.toString(scheduleDays) +
                ", planningName='" + planningName + '\'' +
                ", planningDescription='" + planningDescription + '\'' +
                ", showPl=" + showPl +
                ", repeatCycle=" + repeatCycle +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", color='" + color + '\'' +
                ", colorIcon='" + colorIcon + '\'' +
                ", schedule=" + schedule +
//                ", departments=" + departments +
//                ", planningConfigs=" + planningConfigs +
                '}';
    }
}
