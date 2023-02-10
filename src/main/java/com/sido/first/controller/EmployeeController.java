package com.sido.first.controller;


import com.sido.first.model.entity.Employee;
import com.sido.first.model.entity.dto.EmployeeDTO;
import com.sido.first.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController // sino esto los queries del postman no funcionan
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    public EmpService  empService;
@GetMapping("/get-emp")
    public EmployeeDTO getUser(@RequestParam Integer id){
        return empService.getUSer(id);
    }


    @PostMapping("/post-emp")
    public EmployeeDTO save(@RequestBody EmployeeDTO emp){
        return empService.save(emp);
    }


    @GetMapping("/delete-emp")
    public void delete(@RequestParam Integer id){
         empService.delete(id);
    }

    @PostMapping("/update-emp")
    public EmployeeDTO updateUser(@RequestBody EmployeeDTO emp){
        return empService.updateUser(emp);
    }



}
