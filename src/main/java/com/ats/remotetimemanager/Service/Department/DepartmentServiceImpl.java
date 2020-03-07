package com.ats.remotetimemanager.Service.Department;

import com.ats.remotetimemanager.Model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {


   

    @Override
    public Department add(Department department) {
        return null;
    }

    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department findOne(String name) {
        return null;
    }

    @Override
    public Department findById(Long id) {
        return null;
    }
}
