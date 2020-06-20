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
@Table(name = "user_Configs")
public class UserConfigs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_id")
    private long configId;

    private int[] shownPlannings;
    private boolean theme;



    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"userConfigs"}, allowSetters = true)
    private User user;



    public UserConfigs() {
    }

    public UserConfigs(boolean theme, int[] shownPlannings) {
        this.theme = theme;
        this.shownPlannings = shownPlannings ;
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

    public int[] getShownPlannings() {
        return shownPlannings;
    }

    public void setShownPlannings(int[] shownPlannings) {
        this.shownPlannings = shownPlannings;
    }

    @Override
    public String toString() {
        return "UserConfigs{" +
                "configId=" + configId +
                ", shownPlannings=" + Arrays.toString(shownPlannings) +
                ", theme=" + theme +
                '}';
    }
}
