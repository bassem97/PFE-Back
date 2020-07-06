package com.ats.remotetimemanager.Service.User;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.utill.ChangePasswordVM;
import org.springframework.core.io.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;


public interface UserService {
    User add(User user) throws Exception;
    User update(User user, Long id);
    void delete(long id);
    List<User> findAll();
    User findByUserCIN(String CIN);
    User findById(Long id);
    User makeRevokeAdmin(Long id, Long role);
     boolean changePassword(ChangePasswordVM vm, String CIN);
     User requestUpdate(User user, Long id);
     User acceptUpdate(User user, Long id);
     Set<SimpleGrantedAuthority> getAuthority(User user);
}
