package com.sido.first.respository;

import com.sido.first.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee , Integer> {
}
