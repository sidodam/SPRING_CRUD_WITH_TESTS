package com.sido.first.model.entity.dto;


import com.sido.first.model.entity.Employee;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double salary;


    // convert entity to dtop object

    public static EmployeeDTO toDTO(Employee entity) {
        return EmployeeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .salary(entity.getSalary())
                .build();

    }


}
