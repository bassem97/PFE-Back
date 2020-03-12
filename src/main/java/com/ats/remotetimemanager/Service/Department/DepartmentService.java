package com.ats.remotetimemanager.Service.Department;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.User;

import java.util.List;


public interface DepartmentService {
    Department add(Department department);
    Department update(Department department, Long id);
    void delete(long id);
    List<Department> findAll();
    Department findByName(String name);
    Department findById(Long id);
    User setChefDep(Department department, User user);
    User getChefDep(Department department, User user);
}
