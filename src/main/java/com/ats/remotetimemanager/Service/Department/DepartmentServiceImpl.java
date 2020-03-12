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
    public Department add(Department department) {
        return departmentRepository.save(department);}

    @Override
    public Department update(Department department, Long id) {
        if(departmentRepository.findById(id).isPresent()){
            Department dep= departmentRepository.findById(id).get();
            dep.setDepName(department.getDepName());
            dep.setChefDep(department.getChefDep());
            dep.setDepartments(department.getDepartments());
            dep.setSupDep(department.getSupDep());
            dep.setUsers(department.getUsers());
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

    @Override
    public Department setChefDep(Department department) {
//        department.getUsers().forEach(user -> {
////            if(user.getPost().getPostName().equals("CHEF_DEPARTMENT")){
////
////            }
////        });
        return update(department,1L);
    }
}
