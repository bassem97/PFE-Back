package com.ats.remotetimemanager.Service.User;

import com.ats.remotetimemanager.Model.*;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.PostRepository;
import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.Department.DepartmentService;
import com.ats.remotetimemanager.Service.Image.ImageService;
import com.ats.remotetimemanager.Service.NotificationMail.NotificationMailService;
import com.ats.remotetimemanager.Service.WebSocket.WebSocketService;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private NotificationMailService notificationMailService;

    private final Path root = Paths.get("Images");

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private ImageService imageService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByCin(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getCin(), user.getPassword(), getAuthority(user));
    }

    public Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("asba"));
        });
        return authorities;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) throws Exception {
        Long id =user.getUserId();
        if(userRepository.findById(id).isPresent())
            return null;
        else {
            User newUser = new User();
            if (user.getUserId() != 0)
                newUser.setUserId(user.getUserId());
            newUser.setName(user.getName());
            newUser.setFirstName(user.getFirstName());
            newUser.setGender(user.getGender());
            newUser.setBirthDate(user.getBirthDate());
            newUser.setHireDay(LocalDate.now());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setCin(user.getCin());
            newUser.setUserConfigs(user.getUserConfigs());
            newUser.setImage(user.getImage());
            newUser.setNotificationMessages(user.getNotificationMessages());
            newUser.setAttendances(user.getAttendances());
            //password
            String generatedPassword = randomPassword();
            newUser.setPassword(bcryptEncoder.encode(generatedPassword));
//            newUser.setPassword(bcryptEncoder.encode("123456"));
            newUser.setAddresses(user.getAddresses());
            newUser.setAbsences(user.getAbsences());
            if(user.getRoles().isEmpty()){
                if(userRepository.findAll().isEmpty()){
                    System.out.println("supaddddddd");
                    newUser.getRoles().add(roleRepository.findByRoleName("SUPER_ADMIN"));
                }else{
                    List<User> depUsers;
                    depUsers = userRepository.findAllByDepartment(user.getDepartment());
                    if(depUsers.isEmpty()) {
                        System.out.println("chefdeppppppp");
                        newUser.getRoles().add(roleRepository.findByRoleName("CHEF_DEPARTMENT"));
                    }else {
                        System.out.println("userrrrrrrrr");
                        newUser.getRoles().add(roleRepository.findByRoleName("user"));
                    }
                }
            }else newUser.setRoles(user.getRoles());

            newUser.setDepartment(user.getDepartment());

            if (user.getPost() != null) {
                newUser.setPost(user.getPost());
            }

            // send notification
            try{
                notificationMailService.sendNotification(newUser, generatedPassword);
            }catch (MailException ex) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Erreur email: " + ex.getMessage());
            }
            User u =  userRepository.save(newUser);
            System.out.println(u);
            if(newUser.getRoles().get(0).getRoleName().equals("CHEF_DEPARTMENT")){
                Department dep = departmentRepository.findById(newUser.getDepartment().getDepId());
                dep.setChefDep(u.getUserId());
                departmentService.update(dep,dep.getDepId());
            }
            return u;
        }
    }

    @Override
    public User requestUpdate(User user, Long id) {
//        if(userRepository.findById(id).isPresent()){
            User oldUser = userRepository.findById(id).get();
            List<User> tempUsers = new ArrayList<>();
            tempUsers.add(user);

            return update(oldUser,id);
        }

    @Override
    public User acceptUpdate(User user, Long id) {
        return null;
    }

    @Override
    public User update(User user, Long id) {
        System.out.println("UPDATE");
        if(userRepository.findById(id).isPresent()){
            User newUser =userRepository.findById(id).get();
//            newUser.setUserId(user.getUserId());
            newUser.setName(user.getName());
            newUser.setFirstName(user.getFirstName());
            newUser.setGender(user.getGender());
            newUser.setBirthDate(user.getBirthDate());
//            newUser.setHireDay(user.getHireDay());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setCin(user.getCin());
            Boolean saveDep = false;
            Department dep = null;
//            newUser.setUserConfigs(user.getUserConfigs());
//            newUser.setImage(user.getImage());
            newUser.setAddresses(user.getAddresses());
//            newUser.setNotificationMessages(user.getNotificationMessages());
            if (newUser.getDepartment().getDepId() != user.getDepartment().getDepId() && newUser.getDepartment().getChefDep() == newUser.getUserId()) {
                if (!newUser.isAdmin() ) {
                    newUser.getRoles().clear();
                    newUser.getRoles().add(roleRepository.findByRoleName("USER"));
                }
                dep = departmentRepository.findById(newUser.getDepartment().getDepId());
                dep.setChefDep(0);
                saveDep = true;
            }
            newUser.setDepartment(departmentRepository.findByDepName(user.getDepartment().getDepName()));
            if (user.getPost() != null) {
                newUser.setPost(postRepository.findByPostName(user.getPost().getPostName()));
            } else {
                newUser.setPost(null);
            }
//            else
//                newUser.setPassword(user.getPassword());
//            newUser.setAddresses(user.getAddresses());
//            if( user.getRoles() != null){
//
//                for (Role role: user.getRoles()) {
//                    newUser.getRoles().add(roleRepository.findByRoleName(role.getRoleName()));
//                }
//            }
//            else{
//                newUser.getRoles().add(roleRepository.findByRoleName("USER"));
//            }

//            if(newUser.getPost().getPostName().equals("CHEF_DEPARTMENT")){
//            if(postRepository.findByPostName(user.getPost().getPostName()) .getPostId()== 3){
//                System.out.println("USER ID L9AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH 33333333");
////                System.out.print(newUser.toString());
//                Department dep=  departmentRepository.findById(user.getDepartment().getDepId());
//                dep.setChefDep(newUser.getUserId());
//                departmentService.update(dep,dep.getDepId());
//            }
            System.out.println("BESH YA3MALLOU SAAAAAAAAAAAAAAAVE");
            User r = userRepository.saveAndFlush(newUser);
            if(saveDep) {
                departmentRepository.save(dep);
            }
            return r;
        }else return null ;
//        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        User user = userRepository.findByUserId(id);
        if (user.getDepartment().getChefDep() == id) {
            Department dep = departmentRepository.findById(user.getDepartment().getDepId());
            dep.setChefDep(0);
            departmentRepository.save(dep);
        }
        try {
            userRepository.deleteById(id);
            imageService.delete(user.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public User findByUserCIN(String UserCin) {  return userRepository.findByCin(UserCin);}


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).isPresent()?
         userRepository.findById(id).get() : null;
    }

    @Override
    public User makeRevokeAdmin(Long id, Long role) {
        User user = userRepository.findByUserId(id);
        if (role == 1) {
            user.getRoles().clear();
            user.getRoles().add(roleRepository.findByRoleName("ADMIN"));
        } else {
            Department dep = departmentRepository.findById(user.getDepartment().getDepId());
            if (dep.getChefDep() == user.getUserId()) {
                user.getRoles().clear();
                user.getRoles().add(roleRepository.findByRoleName("CHEF_DEPARTMENT"));
            } else {
                user.getRoles().clear();
                user.getRoles().add(roleRepository.findByRoleName("USER"));
            }
        }
        return userRepository.save(user);
    }

    @Override
    public boolean changePassword(ChangePasswordVM vm , String userCIN){
        User user = findByUserCIN(userCIN);
        System.out.println("----------------"+ bcryptEncoder.encode(vm.getOldPassword()) + "--------------------" + user.getPassword());
        System.out.println("------" + vm.getOldPassword());

        if (bcryptEncoder.matches(vm.getOldPassword(),user.getPassword())){
            user.setPassword(bcryptEncoder.encode(vm.getNewPassword()));
            userRepository.save(user);
            return true;
        }
        else return false;

    }


    // function to generate a random string of length n
    static String randomPassword()
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }



}
