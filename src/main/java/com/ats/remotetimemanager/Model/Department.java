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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long depId;

    private String depName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supDep", referencedColumnName = "dep_Id")
    @JsonIgnoreProperties(value ={"departments","users"} , allowSetters = true)
    private Department supDep;

    @OneToMany(mappedBy = "supDep", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value ={"supDep","users"} , allowSetters = true)
    private List<Department> departments;


    private long chefDep;


//, orphanRemoval = true
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value ={"department"} , allowSetters = true)
    private List<User> users = new ArrayList<>() ;


    public Department() {
    }

    public Department(String depName, Department supDep) {
        this.depName = depName;
        this.supDep = supDep;
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

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", supDep=" + supDep +
                ", departments=" + departments +
                ", chefDep=" + chefDep +
                '}';
    }
}
