package cph.testass3.customer;

import cph.testass3.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers-flyway")
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl customerService;


    @Test
    void createCustomer() {
        Customer c = customerService.createCustomer("HE","LENA", new Date());
        assertNotNull(c);    }
}
