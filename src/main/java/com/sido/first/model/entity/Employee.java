package com.sido.first.model.entity;

import com.sido.first.model.entity.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "employee")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double salary;


    public static Employee toEntity(EmployeeDTO entity){

        return Employee.builder()
                .id(entity.getId())
                .name(entity.getName())
                .salary(entity.getSalary())
                .build();
    }


}

