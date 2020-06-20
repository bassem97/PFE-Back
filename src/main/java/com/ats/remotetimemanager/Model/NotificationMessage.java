package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class NotificationMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notif_id")
    private long notifId;


    private String notifTitle;
    private String  notifDesc;
    private Date notifDate;
    private Boolean isViewed;
    private Boolean isHovered;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"users","notificationMessages"}, allowSetters = true)
    private User user;

    public NotificationMessage() {
    }

    public NotificationMessage(String notifTitle, String notifDesc, Date notifDate, Boolean isViewed, Boolean isHovered) {
        this.notifTitle = notifTitle;
        this.notifDesc = notifDesc;
        this.notifDate = notifDate;
        this.isViewed = isViewed;
        this.isHovered = isHovered;
    }
    public NotificationMessage(String notifTitle, String notifDesc, LocalDate notifDate, Boolean isViewed, Boolean isHovered, User user) {
        this.notifTitle = notifTitle;
        this.notifDesc = notifDesc;
        this.notifDate = notifDate;
        this.isViewed = isViewed;
        this.isHovered = isHovered;
        this.user = user;
    }

    public long getNotifId() {
        return notifId;
    }

    public void setNotifId(long notifId) {
        this.notifId = notifId;
    }

    public String getNotifTitle() {
        return notifTitle;
    }

    public void setNotifTitle(String notifTitle) {
        this.notifTitle = notifTitle;
    }

    public String getNotifDesc() {
        return notifDesc;
    }

    public void setNotifDesc(String notifDesc) {
        this.notifDesc = notifDesc;
    }

    public Date getNotifDate() {
        return notifDate;
    }

    public void setNotifDate(Date notifDate) {
        this.notifDate = notifDate;
    }

    public Boolean getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(Boolean viewed) {
        isViewed = viewed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsHovered() {
        return isHovered;
    }

    public void setIsHovered(Boolean hovered) {
        isHovered = hovered;
    }

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "notifId=" + notifId +
                ", notifTitle='" + notifTitle + '\'' +
                ", notifDesc='" + notifDesc + '\'' +
                ", notifDate=" + notifDate +
                ", isViewed=" + isViewed +
                ", isHovered=" + isHovered +
                ", user=" + user +
                '}';
    }
}
