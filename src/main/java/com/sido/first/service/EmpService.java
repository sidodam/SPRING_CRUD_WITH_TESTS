package com.sido.first.service;

import com.sido.first.model.entity.Employee;
import com.sido.first.model.entity.dto.EmployeeDTO;
import com.sido.first.respository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;



    public EmployeeDTO getUSer(Integer id){

        Optional<Employee> employee = empRepo.findById(id);
        //optional so we can check if it is null or not , avoids null pointer exception


        if (employee.isPresent())
            return EmployeeDTO.toDTO(employee.get());


        else
            return null;

    }

    public EmployeeDTO save(EmployeeDTO emp){
        return EmployeeDTO.toDTO(this.empRepo.save(Employee.toEntity(emp)));

    }

    public void delete(Integer id){
        this.empRepo.deleteById(id);
    }

    public EmployeeDTO updateUser(EmployeeDTO emp){
          return EmployeeDTO.toDTO(this.empRepo.save(Employee.toEntity(emp)));
    }
}
