package com.ats.remotetimemanager.Service.Department;

import com.ats.remotetimemanager.Model.Department;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Department add(Department department) {

        Department newDep = new Department();
        if(department.getDepId() != 0)
            newDep.setDepId(department.getDepId());
        newDep.setDepName(department.getDepName());
        newDep.setChefDep(department.getChefDep());
        newDep.setSupDep(department.getSupDep());
        newDep.setDepartments(department.getDepartments());
        newDep.setUsers(department.getUsers());
//        newDep.setPlanning(department.getPlanning());
        return departmentRepository.save(department);
    }



    @Override
    public Department update(Department department, Long id) {
        if(departmentRepository.findById(id).isPresent()){
            Department dep = departmentRepository.findById(id).get();
            dep.setDepName(department.getDepName());
            dep.setChefDep(department.getChefDep());
            return departmentRepository.save(dep);
        }else return null;

    }

    @Override
    public Department removeChefDep(Long id) {
        if(departmentRepository.findById(id).isPresent()){
            Department dep = departmentRepository.findById(id).get();
            dep.setChefDep(0);
            return departmentRepository.save(dep);
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
    public User getChefDep(Long idDep) {
        return userRepository.findByUserId(departmentRepository.findById(idDep).get().getChefDep());
    }

    @Override
    public Department getSupDep(Long idDep) {
        return departmentRepository.findById(idDep).get().getSupDep();
    }
}
