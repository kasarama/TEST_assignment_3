package cph.testass3.booking;

import cph.testass3.model.Booking;
import cph.testass3.model.Customer;
import cph.testass3.model.Employee;

import java.util.Collection;
import java.util.Date;

public interface BookingService {
    String createNewBooking(Customer customer, Employee employee, Date date, String start, String end);

    Collection<Booking> getBookingsForCustomer(int customerId);
}
