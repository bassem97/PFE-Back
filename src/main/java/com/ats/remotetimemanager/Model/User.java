package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    private String name;
    private String gender;
    private Date birthDate;
    private LocalDate hireDay;

    @Column(unique = true)
    private long phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String CIN;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnoreProperties(value ="users" , allowSetters = true)
    private Post post;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value ="user" , allowSetters = true)
    private List<Address> addresses = new ArrayList<>() ;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "dep_id", nullable = false)
    @JsonIgnoreProperties(value ="users" , allowSetters = true)
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    @JsonIgnoreProperties("users")
    private List<Role> roles = new ArrayList<>();



    public User() {
    }

    public User(String name, String gender, Date birthDay, long phone, String email, String CIN, String password) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDay;
        this.hireDay = LocalDate.now();
        this.phone = phone;
        this.email = email;
        this.CIN = CIN;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
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
