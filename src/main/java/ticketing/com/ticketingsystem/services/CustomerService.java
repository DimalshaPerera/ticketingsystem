package ticketing.com.ticketingsystem.services;

import org.springframework.stereotype.Service;
import ticketing.com.ticketingsystem.models.Customer;
import ticketing.com.ticketingsystem.repositories.CustomerRepoistory;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepoistory customerRepoistory;

    public CustomerService(CustomerRepoistory customerRepoistory) {
        this.customerRepoistory = customerRepoistory;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepoistory.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepoistory.findAll();
    }

}
