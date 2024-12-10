package ticketing.com.ticketingsystem.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ticketing.com.ticketingsystem.models.Customer;
import ticketing.com.ticketingsystem.models.Vendor;
import ticketing.com.ticketingsystem.services.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    // Get all vendors
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
