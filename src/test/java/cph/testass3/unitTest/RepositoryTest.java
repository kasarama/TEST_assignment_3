package cph.testass3.unitTest;

import cph.testass3.booking.BookingRepository;
import cph.testass3.employee.EmployeeRepository;
import cph.testass3.model.Booking;
import cph.testass3.model.Customer;
import cph.testass3.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
public class RepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    Customer c;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void CreateCustomer() {
        String fName = "Magda";
        String lName = "Lena";
        c = customerRepository.save(new Customer(fName, lName, new Date()));
        assertNotNull(c);
        customerRepository.findAll().forEach(c -> {
            System.out.println(c.getFirstName());
        });
    }

    @Test
    void addPhoneNumberForCustomer() {
        String mobile = "81819292";
        c = new Customer("A", "B", new Date());
        c.setMobile(mobile);
        customerRepository.save(c);
        assertTrue(customerRepository.findById(c.getId()).get().getMobile().equals(mobile));

    }

    @Test
    void createEmployee() {
        Employee e = employeeRepository.save(new Employee("Hanna", "Panna", new Date()));
        assertNotNull(e);
    }

    @Test
    void createNewBookingTest() {
        Employee e = employeeRepository.save(new Employee("Hanna", "Panna", new Date()));
        Customer c = customerRepository.save(new Customer("fName", "lName", new Date()));
        Booking b = new Booking(c, e, new Date(), "15:15", "17:30");
        assertTrue(bookingRepository.save(b).getId() > 0);


    }

    @Test
    void getBookingByCustomerTest() {
        Employee e = employeeRepository.save(new Employee("Hanna", "Panna", new Date()));
        Customer c = customerRepository.save(new Customer("fName", "lName", new Date()));
        bookingRepository.save(new Booking(c, e, new Date(), "15:15", "17:30"));
        bookingRepository.save(new Booking(c, e, new Date(), "15:15", "17:30"));
        assertTrue(bookingRepository.getBookingByCustomer_Id(c.getId()).size() > 1);
    }

    @Test
    void getEmployeeByIdsTest() {
        int id1 = employeeRepository.save(new Employee("Hanna", "Panna", new Date())).getId();
        int id2 = employeeRepository.save(new Employee("Hanna", "Panna", new Date())).getId();
        int id3 = employeeRepository.save(new Employee("Hanna", "Panna", new Date())).getId();
        int id4 = employeeRepository.save(new Employee("Hanna", "Panna", new Date())).getId();
        int[] ids = {id1, id2, id3, id4};
        Collection<Employee> employees = employeeRepository.getEmployeesByIdIn(ids);
        assertTrue(employees.size() == 4);
    }

    @Test
    void getBookingByEmployeeTest() {
        Employee e = employeeRepository.save(new Employee("Hanna", "Panna", new Date()));
        Customer c = customerRepository.save(new Customer("fName", "lName", new Date()));
        bookingRepository.save(new Booking(c, e, new Date(), "15:15", "17:30"));
        bookingRepository.save(new Booking(c, e, new Date(), "15:15", "17:30"));
        assertTrue(bookingRepository.getBookingByEmployee_Id(e.getId()).size() > 1);
    }

}
