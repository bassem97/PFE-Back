package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    @Id
    @Column(name = "dep_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long depId;
    private String depName;
    private long chefDep;

    @ManyToOne( fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "supDep", referencedColumnName = "dep_Id")
    @JsonIgnoreProperties(value ={"departments","users"} , allowSetters = true)
    private Department supDep;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "supDep")
    @JsonIgnoreProperties(value ={"supDep","users"} , allowSetters = true)
    private List<Department> departments = new ArrayList<>() ;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id")
    @JsonIgnoreProperties(value ={"department"} , allowSetters = true)
    private List<User> users = new ArrayList<>() ;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id")
    @JsonIgnoreProperties(value ={"department"} , allowSetters = true)
    private List<TempUser> tempUsers = new ArrayList<>() ;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "planning_id" )
    @JsonIgnoreProperties(value ={"plannings","departments"} , allowSetters = true)
    private Planning planning;

    public Department() {
    }


    public Department(String depName, Department supDep, Planning planning) {
        this.depName = depName; 
        this.supDep = supDep;
        this.planning = planning;
    }

    public long getDepId() {
        return depId;
    }

    public void setDepId(long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Department getSupDep() {
        return supDep;
    }

    public void setSupDep(Department supDep) {
        this.supDep = supDep;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public long getChefDep() {
        return chefDep;
    }

    public void setChefDep(long chefDep) {
        this.chefDep = chefDep;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public List<TempUser> getTempUsers() {
        return tempUsers;
    }

    public void setTempUsers(List<TempUser> tempUsers) {
        this.tempUsers = tempUsers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", chefDep=" + chefDep +
//                ", supDep=" + supDep +
//                ", departments=" + departments +
//                ", users=" + users +
                '}';
    }
}
