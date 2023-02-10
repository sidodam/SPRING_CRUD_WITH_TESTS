package com.sido.first;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sido.first.model.entity.Employee;
import com.sido.first.model.entity.dto.EmployeeDTO;
import com.sido.first.respository.EmpRepo;
import com.sido.first.service.EmpService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;


@RunWith(MockitoJUnitRunner.class)
public class EmpServiceTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private EmpRepo empRepo;


    @InjectMocks
    private EmpService empService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(empService).build();


    }

    @Test
    public void testGetUser() {
        Integer id = 1;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("Test Employee");
        Optional<Employee> employeeOptional = Optional.of(employee);
        when(empRepo.findById(id)).thenReturn(employeeOptional);

        EmployeeDTO employeeDTO = empService.getUSer(id);

        assertNotNull(employeeDTO);
        assertEquals(employee.getId(), employeeDTO.getId());
        assertEquals(employee.getName(), employeeDTO.getName());

    }
    @Test
    public void testSave() {
        EmployeeDTO empDTO = new EmployeeDTO(1, "John Doe", 9000.00);
        Employee savedEmp = new Employee(1, "John Doe", 9000.00);
        when(empRepo.save(Employee.toEntity(empDTO))).thenReturn(savedEmp);

        EmployeeDTO savedEmpDTO = empService.save(empDTO);

        assertNotNull(savedEmpDTO);
        assertEquals(savedEmp.getId(), savedEmpDTO.getId());
        assertEquals(savedEmp.getName(), savedEmpDTO.getName());
        assertEquals(savedEmp.getSalary(), savedEmpDTO.getSalary());
    }


    @Test
    public void testUpdate() {
        EmployeeDTO empDTO = new EmployeeDTO(1, "Jane Doe", 7000.00);
        Employee updatedEmp = new Employee(1, "Jane Doe", 7000.00);
        when(empRepo.save(Employee.toEntity(empDTO))).thenReturn(updatedEmp);

        EmployeeDTO updatedEmpDTO = empService.updateUser(empDTO);

        assertNotNull(updatedEmpDTO);
        assertEquals(updatedEmp.getId(), updatedEmpDTO.getId());
        assertEquals(updatedEmp.getName(), updatedEmpDTO.getName());
        assertEquals(updatedEmp.getSalary(), updatedEmpDTO.getSalary());
    }


}
