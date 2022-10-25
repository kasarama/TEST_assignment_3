package cph.testass3.customer;

import cph.testass3.model.Customer;

import java.util.Date;

public interface CustomerService {
    public Customer createCustomer(String firstName, String lastName, Date birthday);
}
