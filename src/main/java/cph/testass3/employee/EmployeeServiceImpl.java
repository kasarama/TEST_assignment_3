package cph.testass3.employee;

import cph.testass3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public int createEmployee(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Collection<Employee> getEmployeesByIds(int[] employeeIds) {
        return employeeRepository.getEmployeesByIdIn(employeeIds);
    }
}
