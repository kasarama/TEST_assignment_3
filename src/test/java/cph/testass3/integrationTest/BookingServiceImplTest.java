package cph.testass3.integrationTest;


import cph.testass3.booking.BookingRepository;
import cph.testass3.booking.BookingServiceImpl;
import cph.testass3.customer.CustomerRepository;
import cph.testass3.employee.EmployeeRepository;
import cph.testass3.model.Booking;
import cph.testass3.model.Customer;
import cph.testass3.model.Employee;
import cph.testass3.notification.SmsServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
class BookingServiceImplTest {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SmsServiceImpl smsService;

    @Autowired
    private BookingServiceImpl bookingService; // = new BookingServiceImpl();

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    private Employee employee;
    private Customer customer;
    private Booking booking;
    int id = 100;
    private Collection<Booking> bookings;

    @BeforeEach
    protected void setUp() {
        employee = employeeRepository.save(new Employee("Magda", "Waw", new Date()));
        customer = customerRepository.save(new Customer("Lena", "Rzak", new Date()));
        booking = new Booking(customer, employee, new Date(), "17.00", "18.00");
    }

    @AfterEach
    protected void cleanUp() {

        bookingRepository.deleteAllInBatch(bookingRepository.findAll());
        employeeRepository.delete(employee);
        customerRepository.delete(customer);


    }

    @Test
    public void contextLoads() {
        assertTrue(bookingService != null);
        assertTrue(bookingRepository != null);
    }

    @Test
    void createNewBooking() {
        String str = bookingService.createNewBooking(customer, employee, booking.getDate(), booking.getStart(), booking.getEnd());
        assertEquals(str, "Sms sent to " + customer.getFirstName());
    }

    @Test
    void getBookingsForCustomer() {
        Collection<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            bookings.add(bookingRepository.save(new Booking(customer, employee, new Date(), "17.00", "18.00")));
        }

        assertTrue(bookingService.getBookingsForEmployee(employee.getId()).size() == bookings.size());
    }

    @Test
    void getBookingsForEmployee() {
        Collection<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            bookings.add(bookingRepository.save(new Booking(customer, employee, new Date(), "17.00", "18.00")));
        }
        assertTrue(bookingService.getBookingsForCustomer(employee.getId()).size() == bookings.size());

    }


}
