package cph.testass3.customer;

import cph.testass3.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(String firstName, String lastName, Date birthday) {
        return customerRepository.save(new Customer(firstName, lastName, birthday));
    }
}
