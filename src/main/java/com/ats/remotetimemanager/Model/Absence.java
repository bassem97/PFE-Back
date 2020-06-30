package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Absence {

    @Id
    @Column(name= "absence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;

    private Date absenceDate;
    private String absenceType; // retard walla aallday
    private String reason;
    private int minutesAbsecnce;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ={"absences"} , allowSetters = true)
    private User user;

    public Absence(Date absenceDate, String absenceType, String reason, int minutesAbsecnce, User user) {
        this.absenceDate = absenceDate;
        this.absenceType = absenceType;
        this.reason = reason;
        this.minutesAbsecnce = minutesAbsecnce;
        this.user = user;
    }

    public Long getIdAbsence() {
        return idAbsence;
    }

    public void setIdAbsence(Long idAbsence) {
        this.idAbsence = idAbsence;
    }

    public Date getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(Date absenceDate) {
        this.absenceDate = absenceDate;
    }

    public String getAbsenceType() {
        return absenceType;
    }

    public void setAbsenceType(String absenceType) {
        this.absenceType = absenceType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMinutesAbsecnce() {
        return minutesAbsecnce;
    }

    public void setMinutesAbsecnce(int minutesAbsecnce) {
        this.minutesAbsecnce = minutesAbsecnce;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
