package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.User;
import com.ats.remotetimemanager.Model.WebSocketMessage;
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

    @Autowired
    private WebSocketController webSocketController;


    @GetMapping("list")
    public List<Department> getAll() { return departmentService.findAll() ;}

    @PostMapping("add")
    public Department add(@RequestBody Department department) throws Exception {
        Department dep3 = departmentService.add(department);
        webSocketController.sendMessage(new WebSocketMessage("department"));
        return dep3;
    }

    @PutMapping("update/{id}")
    public Department update(@Valid @RequestBody Department department, @PathVariable("id") Long id) throws Exception {
        Department dep3 = departmentService.update(department,id);
        webSocketController.sendMessage(new WebSocketMessage("department"));
        return dep3;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        departmentService.delete(id);
        webSocketController.sendMessage(new WebSocketMessage("department"));
    }

    @GetMapping("findByDepName/{name}")
    public Department findByName(@PathVariable("name") String name) { return departmentService.findByName(name);}

    @GetMapping("findById/{id}")
    public Department findById(@PathVariable("id") Long id) {return departmentService.findById(id) ;}

    @GetMapping("getChefDep/{idDep}")
    public User getChefDep(@PathVariable("idDep")Long idDep){
        return departmentService.getChefDep(idDep);
    }

    @GetMapping("getSupDep/{idDep}")
    public Department getSupDep(@PathVariable("idDep")Long idDep){
        return departmentService.getSupDep(idDep);
    }

}
