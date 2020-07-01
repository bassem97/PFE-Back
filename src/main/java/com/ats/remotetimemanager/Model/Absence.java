package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Absence {

    @Id
    @Column(name= "absence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;

    private LocalDate absenceDate;
    private String absenceType; // retard walla aallday
    private String reason;
    private int absentMinutes;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ={"absences"} , allowSetters = true)
    private User user;

    public Absence() {
    }

    public Absence(LocalDate absenceDate, String absenceType, String reason, int absentMinutes) {
        this.absenceDate = absenceDate;
        this.absenceType = absenceType;
        this.reason = reason;
        this.absentMinutes = absentMinutes;
    }
    public Absence(LocalDate absenceDate, String absenceType, String reason) {
        this.absenceDate = absenceDate;
        this.absenceType = absenceType;
        this.reason = reason;
    }

    public Long getIdAbsence() {
        return idAbsence;
    }

    public void setIdAbsence(Long idAbsence) {
        this.idAbsence = idAbsence;
    }

    public LocalDate getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(LocalDate absenceDate) {
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

    public int getAbsentMinutes() {
        return absentMinutes;
    }

    public void setAbsentMinutes(int absentMinutes) {
        this.absentMinutes = absentMinutes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "idAbsence=" + idAbsence +
                ", absenceDate=" + absenceDate +
                ", absenceType='" + absenceType + '\'' +
                ", reason='" + reason + '\'' +
                ", user=" + user +
                '}';
    }
}
