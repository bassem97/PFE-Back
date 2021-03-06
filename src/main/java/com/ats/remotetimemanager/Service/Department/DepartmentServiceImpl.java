package com.ats.remotetimemanager.Service.Department;

import com.ats.remotetimemanager.Model.Department;

import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Repository.RoleRepository;
import com.ats.remotetimemanager.Repository.UserRepository;
import com.ats.remotetimemanager.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.List;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

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
            if(dep.getChefDep() != department.getChefDep()){
                if(department.getChefDep() != 0){
                    User user = userRepository.findByUserId(department.getChefDep());
                    if (user.getRoles().contains(roleRepository.findByRoleName("ADMIN"))  || user.getRoles().contains(roleRepository.findByRoleName("SUPER_ADMIN"))) {
                        System.out.println("admin");
                    } else {
                        System.out.println("mouch admiiiin donc hotlou");
                        user.getRoles().clear();
                        user.getRoles().add(roleRepository.findByRoleName("CHEF_DEPARTMENT"));
                        user.setDepartment(department);
                        userService.update(user, user.getUserId());
                    }
                }

                if(dep.getChefDep() != 0) {
                    User user2 = userRepository.findByUserId(dep.getChefDep());
                    if (user2.getRoles().contains(roleRepository.findByRoleName("ADMIN")) || user2.getRoles().contains(roleRepository.findByRoleName("SUPER_ADMIN"))) {
                        System.out.println("admin");
                    } else {
                        System.out.println("mouch admiiiin donc nahilou");
                        user2.getRoles().clear();
                        user2.getRoles().add(roleRepository.findByRoleName("USER"));
                        user2.setDepartment(department);
                        userService.update(user2, user2.getUserId());
                    }
                }
            }
            dep.setChefDep(department.getChefDep());
            return departmentRepository.save(dep);
        }else return null;
    }


    @Override
    public void delete(long id) { departmentRepository.deleteById(id);}

    @Override
    public List<Department> findAll() { return departmentRepository.findAll() ;}

    @Override
    public Department findByName(String name) { return departmentRepository.findByDepName(name);}

    @Transactional
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
