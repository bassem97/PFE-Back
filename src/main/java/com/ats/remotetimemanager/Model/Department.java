package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @Column(name = "dep_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long depId;

    private String depName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supDep", referencedColumnName = "dep_Id")
    private Department supDep;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_dep_id")
    private User chefDep;

    @OneToMany(mappedBy = "supDep", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Department> departments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value ="department" , allowSetters = true)
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
        depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        depName = depName;
    }

    public Department getSupDep() {
        return supDep;
    }

    public void setSupDep(Department supDep) {
        supDep = supDep;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public User getChefDep() {
        return chefDep;
    }

    public void setChefDep(User chefDep) {
        this.chefDep = chefDep;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
