package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_Config")
public class UserConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_id")
    private long configId;

    private boolean theme;

    @OneToOne
//    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable(name = "PLANNING_CONFIGS", joinColumns = {
            @JoinColumn(name = "config_id") }, inverseJoinColumns = {
            @JoinColumn(name = "planning_id") })
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Planning> plannings = new ArrayList<>();

    public UserConfig() {
    }

    public UserConfig(boolean theme, User user, List<Planning> plannings) {
        this.theme = theme;
        this.user = user;
        this.plannings = plannings;
    }

    public long getConfigId() {
        return configId;
    }

    public void setConfigId(long configId) {
        this.configId = configId;
    }

    public boolean getTheme() {
        return theme;
    }

    public void setTheme(boolean theme) {
        this.theme = theme;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    @Override
    public String toString() {
        return "UserConfig{" +
                "configId=" + configId +
                ", theme='" + theme + '\'' +
                ", user=" + user +
                ", plannings=" + plannings +
                '}';
    }
}
