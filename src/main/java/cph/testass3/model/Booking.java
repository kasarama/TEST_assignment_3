package cph.testass3.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date", nullable = false)
    private Date date;


    @Column(name = "start_time", nullable = false)
    private String start;


    @Column(name = "end_time", nullable = false)
    private String end;

    public Booking(Customer customer, Employee employee, Date date, String start, String end) {
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.start = start;
        this.end = end;
    }
}


