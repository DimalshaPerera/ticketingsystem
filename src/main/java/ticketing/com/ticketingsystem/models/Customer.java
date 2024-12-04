package ticketing.com.ticketingsystem.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Customer implements Runnable {
    private @Id
    @GeneratedValue long ticketId;
    private TicketPool ticketPool; //shared between customers and vendors
    private int customerRetrieveRate; //frequency which tickets will be removed from the pool
    private int quantity;  //quantity the customer willing to buy

    @Override
    public void run(){
        for(int i=0; i<quantity; i++){
            //write something
        }
    }
}
