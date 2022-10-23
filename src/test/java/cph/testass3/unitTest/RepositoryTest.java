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

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
        c= new Customer ("A","B",new Date());
        c.setMobile(mobile);
        customerRepository.save(c);
        assertTrue(customerRepository.findById(c.getId()).get().getMobile().equals(mobile));

    }

    @Test
    void createEmployee() {
        Employee e= employeeRepository.save(new Employee("Hanna", "Panna", new Date()));
        assertNotNull(e);
    }

    @Test
    void createNewBooking() {
        Employee e= employeeRepository.save(new Employee("Hanna", "Panna", new Date()));
        Customer c = customerRepository.save(new Customer("fName", "lName", new Date()));
        Booking b = new Booking(c,e, new Date(), "15:15","17:30");
        assertTrue(bookingRepository.save(b).getId()>0);
}
}
