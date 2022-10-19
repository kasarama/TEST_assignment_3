package cph.testass3.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthdate;
}
