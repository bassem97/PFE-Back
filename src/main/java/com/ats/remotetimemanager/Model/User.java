package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User  {

    private static Long count = 0L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private long userId;
    private String name;
    private String firstName;
    private String gender;

    private String birthDate;

    private LocalDate hireDay;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cin;

    private String password;






    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnoreProperties(value ="users" , allowSetters = true)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dep_id")
    @JsonIgnoreProperties(value ={"users","departments"} , allowSetters = true)
    private Department department;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ="user" , allowSetters = true)
    private List<Address> addresses = new ArrayList<>() ;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    @JsonIgnoreProperties("users")
    private List<Role> roles = new ArrayList<>();




    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private List<UserConfigs> userConfigs = new ArrayList<>();



    public User() {
    }

    public User(String name, String firstName, String gender, String birthDate, String phone, String email, String cin, String password, Post post, Department department) {
        this.name = name;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hireDay = LocalDate.now();
        this.phone = phone;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.post = post;
        this.department = department;
        this.userId = ++count;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<UserConfigs> getUserConfigs() {
        return userConfigs;
    }

    public void setUserConfigs(List<UserConfigs> userConfigs) {
        this.userConfigs = userConfigs;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", hireDay=" + hireDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cin='" + cin + '\'' +
                ", password='" + password + '\'' +
                ", post=" + post +
                ", department=" + department +
                ", addresses=" + addresses +
                ", roles=" + roles +
                '}';
    }

    //    public int getAge(){
//        long ageInMillis = new Date().getTime() - getBirthDate().getTime();
//        Date age = new Date(ageInMillis);
//        return age.getYear();
//    }
//    public int getWorkPeriod(){
//        long ageInMillis = new Date().getYear() - getHireDay().getYear();
//        Date age = new Date(ageInMillis);
//        return age.getYear();
//    }
}
