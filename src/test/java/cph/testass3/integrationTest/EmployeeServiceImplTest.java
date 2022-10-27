package cph.testass3.integrationTest;

import cph.testass3.employee.EmployeeRepository;
import cph.testass3.employee.EmployeeServiceImpl;
import cph.testass3.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl employeeService;

    private Employee employee;
    private Collection<Employee> employees = new ArrayList<>();
    private int id = 99;

    @BeforeEach
    void setUp() {
        employee = new Employee("Magda", "Waw", new Date());
        employees.add(employeeRepository.save(employee));
        employees.add(employeeRepository.save(employee));
        employees.add(employeeRepository.save(employee));

    }

    @AfterEach
    void cleanUp() {
        employeeRepository.deleteAll();
    }

    @Test
    void createEmployee() {
        int id1 = employeeService.createEmployee(employee);
        int id2 = employeeService.createEmployee(employee);
        assertTrue(id1 < id2);
    }

    @Test
    void getEmployeeById() {
        assertTrue(employeeService.getEmployeeById(id) == employee);
    }

    @Test
    void getEmployeesByIds() {
        int[] ids = new int[3];
        for (int j = 0; j < 3; j++) {
            ids[j] = employeeService.createEmployee(new Employee());
        }
        assertTrue(employeeService.getEmployeesByIds(ids).size() == 3);
    }
}