package com.ats.remotetimemanager.Service.User;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

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
        if(userRepository.findById(user.getUserId()).isPresent()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }else return null;
    }

    @Override
    public User update(User user, Long id) {
        return userRepository.save(user);
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
