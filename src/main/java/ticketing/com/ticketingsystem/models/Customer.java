package ticketing.com.ticketingsystem.models;

import jakarta.persistence.*;
import ticketing.com.ticketingsystem.services.CustomerService;

@Entity
public class Customer implements Runnable {
    @Id
    @GeneratedValue
    private long customerId;
    @ManyToOne
    private TicketPool ticketPool; //shared between customers and vendors
    private int customerRetrieveRate; //frequency which tickets will be removed from the pool
    private int quantity;  //quantity the customer willing to buy
    private int numOfCustomers;

    @Transient
    private CustomerService customerService;

    public Customer(TicketPool ticketPool, int customerRetrieveRate, int quantity, CustomerService customerService) {
        this.ticketPool = ticketPool;
        this.customerRetrieveRate = customerRetrieveRate;
        this.quantity = quantity;
        this.customerService = customerService;
    }

    public Customer() {
    }


    @Override
    public void run(){
        for(int i=0; i<quantity; i++){
            Ticket ticket = ticketPool.buyTicket();
            customerService.saveCustomer(this);
            try{
                Thread.sleep(customerRetrieveRate*1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
