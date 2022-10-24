package cph.testass3.booking;

import cph.testass3.model.Booking;
import cph.testass3.model.Customer;
import cph.testass3.model.Employee;
import cph.testass3.notification.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    SmsServiceImpl smsService;
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public String createNewBooking(Customer customer, Employee employee, Date date, String start, String end) {

        Booking b = bookingRepository.save(new Booking(customer, employee, date, start, end));
        return smsService.sendSms(b.getCustomer().getFirstName());
    }

    @Override
    public Collection<Booking> getBookingsForCustomer(int customerId) {
        return bookingRepository.getBookingByCustomer_Id(customerId);
    }

    @Override
    public Collection<Booking> getBookingsForEmployee(int employeeId) {
        return bookingRepository.getBookingByEmployee_Id(employeeId);
    }

}
