package com.ats.remotetimemanager.Service.User;

import ch.qos.logback.classic.joran.action.LoggerAction;
import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.Role;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.Department.DepartmentService;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service(value = "userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDetails loadUserByCIN(String CIN) throws UsernameNotFoundException {
        User user = userRepository.findByCIN(CIN);
        if(user == null){
            throw new UsernameNotFoundException("Invalid CIN or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getCIN(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User add(User user) {
        Long id =user.getUserId();
        if(userRepository.findById(id).isPresent())
            return null;
        else{
            User newUser = new User();
            if(user.getUserId() != 0)
                newUser.setUserId(user.getUserId());
            newUser.setName(user.getName());
            newUser.setGender(user.getGender());
            newUser.setBirthDate(user.getBirthDate());
            newUser.setHireDay(LocalDate.now());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setCIN(user.getCIN());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            newUser.setAddresses(user.getAddresses());
            newUser.setDepartment(user.getDepartment());
            if(user.getPost().getPostId() == 3){
                Department dep=  user.getDepartment();
                dep.setChefDep(user.getUserId());
                departmentRepository.save(dep);

            }

            if( user.getRoles() != null){
                for (Role role: user.getRoles()) {
                    newUser.getRoles().add(roleRepository.findByRoleName(role.getRoleName()));
                }
            }
            else{
                newUser.getRoles().add(roleRepository.findByRoleName("USER"));
            }
            newUser.setPost(user.getPost());
            if(user.getPost().getPostId() == 3){
                System.out.print("ahaaddddddddddddddd ");
                Department dep=  user.getDepartment();
                dep.setChefDep(user.getUserId());
                departmentService.update(dep,dep.getDepId());

            }
            return userRepository.saveAndFlush(newUser);
        }
    }

    @Override
    public User update(User user, Long id) {
        if(userRepository.findById(id).isPresent()){
            User newUser =userRepository.findById(id).get();
//            newUser.setUserId(user.getUserId());
            newUser.setName(user.getName());
            newUser.setGender(user.getGender());
            newUser.setBirthDate(user.getBirthDate());
//            newUser.setHireDay(user.getHireDay());
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setCIN(user.getCIN());
            newUser.setDepartment(user.getDepartment());
            if(user.getPassword() != null)
                newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            else
                newUser.setPassword(user.getPassword());
//            newUser.setAddresses(user.getAddresses());
            newUser.setDepartment(user.getDepartment());
            if( user.getRoles() != null){

                for (Role role: user.getRoles()) {
                    newUser.getRoles().add(roleRepository.findByRoleName(role.getRoleName()));
                }
            }
            else{
                newUser.getRoles().add(roleRepository.findByRoleName("USER"));
            }
            newUser.setPost(user.getPost());
            if(newUser.getPost().getPostId() == 3){
//                System.out.print(newUser.toString());
                Department dep=  user.getDepartment();
                dep.setChefDep(newUser.getUserId());
                departmentService.update(dep,dep.getDepId());
            }


            return userRepository.save(newUser);
        }else return null ;
//        return userRepository.save(user);
    }

    @Override
    public void delete(long id) { userRepository.deleteById(id);}



    @Override
    public User findByCIN(String CIN) {  return userRepository.findByCIN(CIN);}


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).isPresent()?
         userRepository.findById(id).get() : null;
    }

    @Override
    public boolean changePassword(ChangePasswordVM vm , String CIN){
        User user = findByCIN(CIN);
        System.out.println("----------------"+ passwordEncoder.encode(vm.getOldPassword()) + "--------------------" + user.getPassword());
        System.out.println("------" + vm.getOldPassword());

        if (passwordEncoder.matches(vm.getOldPassword(),user.getPassword())){
            user.setPassword(passwordEncoder.encode(vm.getNewPassword()));
            userRepository.save(user);
            return true;
        }
        else return false;

    }
}
