package ticketing.com.ticketingsystem.services;

import org.springframework.stereotype.Service;
import ticketing.com.ticketingsystem.models.Customer;
import ticketing.com.ticketingsystem.models.TicketPool;
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

    public void StartCustomerThread(TicketPool ticketPool,int customerRetrievalRate,int quantity) {
        Customer[] customers = new Customer[10];//An array of customers
        for(int i=0; i<customers.length; i++){
            customers[i] = new Customer(ticketPool,customerRetrievalRate,quantity,this);
            Thread customerThread = new Thread(customers[i],"Customer: "+i);
            customerThread.start();
        }

    }

}
