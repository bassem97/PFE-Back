package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("list")
    public List<Department> getAll() { return departmentService.findAll() ;}

    @PostMapping("add")
    public Department add(@RequestBody Department department) { return departmentService.add(department);}

    @PutMapping("update/{id}")
    public Department update(@Valid @RequestBody Department department, @PathVariable("id") Long id){ return departmentService.update(department,id);}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) { departmentService.delete(id);}

    @GetMapping("findByName/{name}")
    public Department findByName(@PathVariable("name") String name) { return departmentService.findByName(name);}

    @GetMapping("findById/{id}")
    public Department findById(@PathVariable("id") Long id) {return departmentService.findById(id) ;}



}
