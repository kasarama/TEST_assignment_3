package cph.testass3.employee;

import cph.testass3.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    //int createEmployee(Employee employee);
    int createEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    Collection<Employee> getEmployeesByIds(int[] employeeIds);
}
