package com.ats.remotetimemanager.Service.Department;

import com.ats.remotetimemanager.Model.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    Department add(Department department);
    Department update(Department department);
    void delete(long id);
    List<Department> findAll();
    Department findOne(String name);
    Department findById(Long id);
}
