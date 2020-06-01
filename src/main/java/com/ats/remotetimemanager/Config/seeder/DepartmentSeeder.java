package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import com.ats.remotetimemanager.Service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentSeeder {

    @Autowired
    private DepartmentRepository departmentRepository ;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PostSeeder postSeeder;

    Department info = new Department("informatique", null);
    Department security = new Department("security", info);
    Department khra = new Department("Resources humaines", security);


    Department mark = new Department("marketing", null);



    public  void seed(){
        if(departmentRepository.findAll().isEmpty()){
            departmentService.add(info);
            departmentService.add(security );
            departmentService.add(khra);
            departmentService.add(mark);
        }
//        Department mahMahMahMah = departmentRepository.findById(1L).get();
//        Department moud = new Department("MAh", mahMahMahMah);
//        // departmentService.add(moud);


    }

}
