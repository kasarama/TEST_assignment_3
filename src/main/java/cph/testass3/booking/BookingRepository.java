package cph.testass3.booking;

import cph.testass3.model.Booking;
import cph.testass3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Collection<Booking> getBookingByCustomer_Id(int customerId);
}
