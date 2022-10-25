package cph.testass3.customer;

import cph.testass3.employee.EmployeeRepository;
import cph.testass3.employee.EmployeeServiceImpl;
import cph.testass3.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    private Employee employee = new Employee(99, "Magda", "Waw", new Date());
    private Collection<Employee> employees = new ArrayList<>();
    private int id = 99;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);
        when(employeeRepository.getEmployeesByIdIn(any())).thenReturn(employees);
        when(employeeRepository.save(any())).thenReturn(employee);
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(employee));
    }

    @Test
    void createEmployee() {
        assertEquals(employeeService.createEmployee(employee), employee.getId());
    }

    @Test
    void getEmployeeById() {
        assertTrue(employeeService.getEmployeeById(id) == employee);
    }

    @Test
    void getEmployeesByIds() {
        int[] ids = {1, 2, 3};
        assertTrue(employeeService.getEmployeesByIds(ids).size() == 3);
    }
}