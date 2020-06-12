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
    @JsonIgnoreProperties("userConfig")
    private User user;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable(name = "PLANNING_CONFIGS", joinColumns = {
            @JoinColumn(name = "config_id") }, inverseJoinColumns = {
            @JoinColumn(name = "planning_id") })
    private List<Planning> shownPlannings = new ArrayList<>();

    public UserConfig() {
    }

    public UserConfig(boolean theme, User user, List<Planning> shownPlannings) {
        this.theme = theme;
        this.user = user;
        this.shownPlannings = shownPlannings;
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


    public List<Planning> getshownPlannings() {
        return shownPlannings;
    }

    public void setshownPlannings(List<Planning> shownPlannings) {
        this.shownPlannings = shownPlannings;
    }

    @Override
    public String toString() {
        return "UserConfig{" +
                "configId=" + configId +
                ", theme='" + theme + '\'' +
                ", user=" + user +
                ", plannings=" + shownPlannings +
                '}';
    }
}
