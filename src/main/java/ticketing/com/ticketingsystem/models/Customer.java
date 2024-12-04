package ticketing.com.ticketingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer implements Runnable {
    @Id
    @GeneratedValue
    private long ticketId;
    @ManyToOne
    private TicketPool ticketPool; //shared between customers and vendors
    private int customerRetrieveRate; //frequency which tickets will be removed from the pool
    private int quantity;  //quantity the customer willing to buy

    public Customer(TicketPool ticketPool, int customerRetrieveRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrieveRate = customerRetrieveRate;
        this.quantity = quantity;
    }

    public Customer() {
    }


    @Override
    public void run(){
        for(int i=0; i<quantity; i++){
            Ticket ticket = ticketPool.buyTicket();
            System.out.println(ticket+"Ticket bought by"+Thread.currentThread().getName());

            try{
                Thread.sleep(customerRetrieveRate*1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
