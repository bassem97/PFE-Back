package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Attendance {

    @Id
    @Column(name= "attendance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAttendance;

    //chekin checkout
    private String attendanceType ;

    //card finger password
    private String inputType;

    private int attendanceTime;

    private LocalDate attendanceDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ={"attendances","department","notificationMessages"} , allowSetters = true)
    private User user;

    public Attendance() {
    }

    public Attendance(String attendanceType, String inputType, int attendanceTime, LocalDate attendanceDate) {
        this.attendanceType = attendanceType;
        this.inputType = inputType;
        this.attendanceTime = attendanceTime;
        this.attendanceDate = attendanceDate;
    }

    public Long getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Long idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public int getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(int attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
