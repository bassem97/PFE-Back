package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentSeeder {

    @Autowired
    private DepartmentRepository departmentRepository ;
    Department info = new Department("informatique", null);
    Department security = new Department("security", info);
    Department khra = new Department("khra", security);
    Department mark = new Department("marketing", null);
    public  void seed(){

        if(departmentRepository.findAll().isEmpty()){
            departmentRepository.save(khra);
            departmentRepository.save(mark);
        }
    }
}
