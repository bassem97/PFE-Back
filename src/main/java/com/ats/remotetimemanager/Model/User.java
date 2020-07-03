package com.ats.remotetimemanager.Model;

import com.ats.remotetimemanager.Repository.ScheduleRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    private String image;






    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ="user" , allowSetters = true)
    private List<Attendance> attendances = new ArrayList<>() ;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ="user" , allowSetters = true)
    private List<Absence> absences = new ArrayList<>() ;


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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private List<NotificationMessage> notificationMessages = new ArrayList<>();



    public User() {
    }

    public User(String name, String firstName, String gender, String birthDate, String phone, String email, String cin, String password, Post post, Department department, String image) {
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
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<NotificationMessage> getNotificationMessages() {
        return notificationMessages;
    }

    public void setNotificationMessages(List<NotificationMessage> notificationMessages) {
        this.notificationMessages = notificationMessages;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    @Autowired
    public void addAttendance(Attendance att){
        List<Attendance> attendances = this.getAttendances();
            if(this.department.getPlanning().getPlanningConfigs().get(0) != null && att != null ){
                if(attendances.size() != 0) {
                    if(this.department.getPlanning().getSchedule() != null){
                        PlanningConfig planConf = this.department.getPlanning().getPlanningConfigs().get(0);
                        Schedule schedule = this.department.getPlanning().getSchedule();
                        Attendance lastAttendance = attendances.get(attendances.size() - 1);
                        //Search whole days absent
                        if(lastAttendance.getAttendanceType().equals("CHECK OUT") && att.getAttendanceType().equals("CHECK IN") && absentAllDay(lastAttendance , att) != 0){
                            if(department.getPlanning().getSchedule() != null){
                                fetchAbsentDays(lastAttendance,att,schedule);
                            }
                        }
                        //save delay minutes
                        calculateDelay(att,planConf,schedule,att.getAttendanceType());
                    }
                }
                attendances.add(att);
            }
    }

    private void calculateDelay(Attendance att, PlanningConfig planConf, Schedule schedule, String type) {
        if(type.equals("CHECK IN")){
            int startHour = schedule.getStartHour();
            int checkIn = att.getAttendanceTime();
            int checkInDelay = planConf.getCheckInDelay();
            int delay = checkIn - (checkInDelay + startHour);
            if(delay > 0) {
                newAbsence(att.getAttendanceDate(),"Late Check in", "No reason yet",delay);
            }
        }else {
            int endHour = schedule.getEndHour();
            int checkOut = att.getAttendanceTime();
            int checkOutDelay = planConf.getCheckOutDelay();
            int delay = (endHour - checkOutDelay) - checkOut;
            if(delay > 0) {
                newAbsence(att.getAttendanceDate(),"Early Check out", "No reason yet",delay);
            }
        }
    }
    private void fetchAbsentDays(Attendance lastAttendance, Attendance att, Schedule schedule) {
        int workMinutes = schedule.getWorkMinutes();
        Long absenceDays = absentAllDay(lastAttendance , att);
        List<String> scheduleDays = Arrays.asList(department.getPlanning().getScheduleDays());
        for (int i= 1; i<absenceDays; i++ ) {
            LocalDate absentDay = lastAttendance.getAttendanceDate().plusDays(i);
            if(scheduleDays.contains(absentDay.getDayOfWeek().toString())){
                newAbsence(absentDay,"All Day","No reason yet",workMinutes);
            }
        }
    }

    private void newAbsence(LocalDate absentDay, String type, String reason, int workMinutes) {
        Absence absence = new Absence(absentDay, type, reason,workMinutes, "yellow", null);
        this.getAbsences().add(absence);
    }

    private Long absentAllDay(Attendance lastAttendance, Attendance att) {
        LocalDate lastAttDate = lastAttendance.getAttendanceDate() ;
        LocalDate attDate = att.getAttendanceDate();
        return ChronoUnit.DAYS.between(lastAttDate,attDate);
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
                ", image='" + image + '\'' +
                ", post=" + post +
//                ", department=" + department +
                ", addresses=" + addresses +
                ", roles=" + roles +
                ", userConfigs=" + userConfigs +
//                ", notificationMessages=" + notificationMessages +
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
