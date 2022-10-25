package cph.testass3.customer;


import cph.testass3.booking.BookingRepository;
import cph.testass3.booking.BookingServiceImpl;
import cph.testass3.model.Booking;
import cph.testass3.model.Customer;
import cph.testass3.model.Employee;
import cph.testass3.notification.SmsServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
public class BookingServiceImplTest {


    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private SmsServiceImpl smsService;

    @InjectMocks
    private BookingServiceImpl bookingService = new BookingServiceImpl();

    private Employee employee = new Employee(10, "Magda", "Waw", new Date());
    private Customer customer = new Customer(11, "Lena", "Rzak", new Date(), "88998899");
    private Booking booking = new Booking(1, customer, employee, new Date(), "17.00", "18.00");
    int id = 100;
    private Collection<Booking> bookings = new ArrayList<>();
    private String output = "JEJE";

    @BeforeEach
    protected void setUp() {

        bookings.add(booking);
        bookings.add(booking);
        bookings.add(booking);
        MockitoAnnotations.openMocks(this);
        when(bookingRepository.getBookingByCustomer_Id(id)).thenReturn(bookings);
        when(bookingRepository.getBookingByEmployee_Id(id)).thenReturn(bookings);
        when(bookingRepository.save(any())).thenReturn(booking);
        when(smsService.sendSms(any())).thenReturn(output);
    }

    @Test
    public void contextLoads() {
        assertTrue(bookingService != null);
        assertTrue(bookingRepository != null);
    }

    @Test
    void createNewBooking() {
        String str = bookingService.createNewBooking(customer, employee, booking.getDate(), booking.getStart(), booking.getEnd());
        assertEquals(str, output);
    }

    @Test
    void getBookingsForCustomer() {
        assertEquals(bookingService.getBookingsForEmployee(id), bookings);
    }

    @Test
    void getBookingsForEmployee() {
        assertEquals(bookingService.getBookingsForCustomer(id), bookings);

    }


}
