package cph.testass3.unitTest;

import cph.testass3.customer.CustomerRepository;
import cph.testass3.customer.CustomerServiceImpl;
import cph.testass3.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
class CustomerServiceImplTest {

    @MockBean
    CustomerRepository customerRepository;
    @Autowired
    private CustomerServiceImpl customerService;
    private Customer customer;

    @BeforeEach
    void setup() {
        customer = new Customer(1, "MA", "GDA", new Date(), "mobile");
        when(customerRepository.save(ArgumentMatchers.any())).thenReturn(customer);
    }

    @Test
    void createCustomer() {
        Customer c = customerService.createCustomer("HE", "LENA", new Date());
        assertNotNull(c);
        assertTrue(c.equals(customer));
    }
}
