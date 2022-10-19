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

/*
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "customer_id")
    private Integer customerId;
*/
    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date", nullable = false)
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time", nullable = false)
    private Date start;

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time", nullable = false)
    private Date end;

}


