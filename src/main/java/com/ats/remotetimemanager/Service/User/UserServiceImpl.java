package com.ats.remotetimemanager.Service.User;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.Role;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.PostRepository;
import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.Department.DepartmentService;
import com.ats.remotetimemanager.Service.Notification.NotificationService;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
    private NotificationService notificationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByCin(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getCin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        return null;
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRoles().forEach(role -> {
//            //authorities.add(new SimpleGrantedAuthority(role.getName()));
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        });
//        return authorities;
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public String[] editImage(String[] image, long id) throws IOException {
        System.out.println(image[0]+"  "+image[1]);
        File filePath = new File(image[0]);
        FileInputStream input = new FileInputStream(filePath);
        String type = filePath.getName().substring(filePath.getName().lastIndexOf(".")+1);
        MultipartFile file = new MockMultipartFile("file", filePath.getName(),type, IOUtils.toByteArray(input));
        String name = file.getContentType().replaceAll("image/", id + type);
        String path = "C:\\Users\\Bassem's PC\\Desktop\\PFE\\PFE-back\\src\\main\\resources\\Images\\"+ name;
        file.transferTo(filePath);
        return  new String[] {path,name};

    }

    @Override
    public User add(User user) {
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
            //password
            String generatedPassword = randomPassword();
            newUser.setPassword(bcryptEncoder.encode(generatedPassword));
            newUser.setAddresses(user.getAddresses());
            newUser.setDepartment(user.getDepartment());
            newUser.setPost(user.getPost());
            if (user.getPost().getPostId() == 3) {
//            if (postRepository.findByPostName(newUser.getPost().getPostName()).equals("CHEF_DEPARTMENT")) {
                Department dep = departmentRepository.findById(user.getDepartment().getDepId());
                dep.setChefDep(user.getUserId());
                departmentRepository.save(dep);

            }

//            if(user.getPost().getPostId() == 3){
//                System.out.print("ahaaddddddddddddddd ");
//                Department dep=  user.getDepartment();
//                dep.setChefDep(user.getUserId());
//                departmentService.update(dep,dep.getDepId());
            // send notification
            try{
                notificationService.sendNotification(newUser, generatedPassword);
            }catch (MailException ex){
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Erreur email: "+ex.getMessage());
            }
            //return confirmation
            User u = userRepository.save(newUser);
            if(u.getImage() == null){
                try {
                newUser.setImage(editImage(user.getImage(),u.getUserId()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("newUser"+newUser);
            return update(newUser,u.getUserId()) ;
            }else  return userRepository.save(newUser);
        }
    }

    @Override
    public User update(User user, Long id) {
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
            newUser.setUserConfigs(user.getUserConfigs());
            newUser.setImage(user.getImage());
            newUser.setDepartment(departmentRepository.findByDepName(user.getDepartment().getDepName()));
            newUser.setPost(postRepository.findByPostName(user.getPost().getPostName()));
            if(user.getPassword() != null)
                newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//            else
//                newUser.setPassword(user.getPassword());
//            newUser.setAddresses(user.getAddresses());
            if( user.getRoles() != null){

                for (Role role: user.getRoles()) {
                    newUser.getRoles().add(roleRepository.findByRoleName(role.getRoleName()));
                }
            }
            else{
                newUser.getRoles().add(roleRepository.findByRoleName("USER"));
            }

//            if(newUser.getPost().getPostName().equals("CHEF_DEPARTMENT")){
            if(postRepository.findByPostName(user.getPost().getPostName()) .getPostId()== 3){
                System.out.println("USER ID L9AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH 33333333");
//                System.out.print(newUser.toString());
                Department dep=  departmentRepository.findById(user.getDepartment().getDepId());
                dep.setChefDep(newUser.getUserId());
                departmentService.update(dep,dep.getDepId());
            }
            System.out.println("BESH YA3MALLOU SAAAAAAAAAAAAAAAVE");
            return userRepository.save(newUser);
        }else return null ;
//        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        if (userRepository.findByUserId(id).getDepartment().getChefDep() == id) {
            departmentService.removeChefDep(userRepository.findByUserId(id).getDepartment().getDepId());
        }
        User user = userRepository.findByUserId(id);
        if(user.getImage().length != 0){
            File file = new File(user.getImage()[0]);
            file.delete();
        }

        userRepository.deleteById(id);

    }



    @Override
    public User findByUserCIN(String UserCin) {  return userRepository.findByCin(UserCin);}


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).isPresent()?
         userRepository.findById(id).get() : null;
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
