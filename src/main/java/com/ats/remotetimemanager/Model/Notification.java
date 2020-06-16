package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notif_id")
    private long notifId;


    private String  notifName;
    private String  notifDesc;
    private LocalDate notifDate;
    private Boolean isViewed;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"notifications"}, allowSetters = true)
    private User user;

    public Notification() {
    }

    public Notification(String notifName, String notifDesc, LocalDate notifDate, Boolean isViewed) {
        this.notifName = notifName;
        this.notifDesc = notifDesc;
        this.notifDate = notifDate;
        this.isViewed = isViewed;
    }

    public long getNotifId() {
        return notifId;
    }

    public void setNotifId(long notifId) {
        this.notifId = notifId;
    }

    public String getNotifName() {
        return notifName;
    }

    public void setNotifName(String notifName) {
        this.notifName = notifName;
    }

    public String getNotifDesc() {
        return notifDesc;
    }

    public void setNotifDesc(String notifDesc) {
        this.notifDesc = notifDesc;
    }

    public LocalDate getNotifDate() {
        return notifDate;
    }

    public void setNotifDate(LocalDate notifDate) {
        this.notifDate = notifDate;
    }

    public Boolean getViewed() {
        return isViewed;
    }

    public void setViewed(Boolean viewed) {
        isViewed = viewed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "NotificationMail{" +
                "notifId=" + notifId +
                ", notifName='" + notifName + '\'' +
                ", notifDesc='" + notifDesc + '\'' +
                ", notifDate=" + notifDate +
                ", isViewed=" + isViewed +
                ", user=" + user +
                '}';
    }
}
