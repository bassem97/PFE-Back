package com.ats.remotetimemanager.Service.User;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.utill.ChangePasswordVM;

import java.util.List;


public interface UserService {
    User add(User user);
    User update(User user, Long id);
    void delete(long id);
    List<User> findAll();

    User findByCIN(String CIN);
    User findById(Long id);
    public boolean changePassword(ChangePasswordVM vm, String CIN);
}
