package cph.testass3.customer;

import cph.testass3.model.Customer;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerSteps {

    @ParameterType("\\d{2}\\-\\d{2}\\-\\d{4}")
    public Date date(String dateString) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
    }

    @Autowired
    CustomerService customerService;

    Customer customer;
    private String firstName;
    private String lastName;
    private Date birthday;

    @Given("Firstname {string}, lastname {string} and birthday {string}")
    public void customer_service(String firstName, String lastName, String birthday) throws ParseException {
        this.birthday = date(birthday);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @When("Creating new Customer")
    public void customer_provides_firstname_lastname_and_birthdate() throws ParseException {
        customer = customerService.createCustomer(firstName, lastName, birthday);
        System.out.println(customer.getId());
    }


    @Before
    public void setup() {
        System.out.println("Hello");
    }

    @Then("New Customer is created with firstname {string}, lastname {string}, birthday {string} and new id")
    public void new_customer_is_created_with_firstname_lastname_and_birthday(String firstName, String lastName, String birthday) throws ParseException {
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertTrue(firstName.equals(customer.getFirstName()));
        assertTrue(lastName.equals(customer.getLastName()));
        assertTrue(date(birthday).equals(customer.getBirthdate()));
        System.out.println(customer.getId());
    }


}

