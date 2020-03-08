package com.ats.remotetimemanager.Service.Department;

import com.ats.remotetimemanager.Model.Department;

import com.ats.remotetimemanager.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department add(Department department) { return departmentRepository.save(department);}

    @Override
    public Department update(Department department, Long id) {
        if(departmentRepository.findById(id).isPresent()){
            Department dep= departmentRepository.findById(id).get();
            dep.setDepName(dep.getDepName());
            dep.setChefDep(dep.getChefDep());
            dep.setDepartments(dep.getDepartments());
            dep.setSupDep(dep.getSupDep());
            dep.setUsers(dep.getUsers());
            return departmentRepository.saveAndFlush(dep);
        }else return null;

    }

    @Override
    public void delete(long id) { departmentRepository.deleteById(id);}

    @Override
    public List<Department> findAll() { return departmentRepository.findAll() ;}

    @Override
    public Department findByName(String name) { return departmentRepository.findByDepName(name);}

    @Override
    public Department findById(Long id) {return departmentRepository.findById(id).get() ;}
}
