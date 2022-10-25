package cph.testass3.employee;

import cph.testass3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Collection<Employee> getEmployeesByIdIn(int[] ids);



}
