package ticketing.com.ticketingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class TicketPool {
    private @Id @GeneratedValue long ticketPoolId;
    @OneToMany //WRITE A COMMENT
    private List<Ticket> ticketsList;
    private int maximumCapacity;


    public TicketPool() {}

    public TicketPool(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.ticketsList= Collections.synchronizedList(new ArrayList<>());
    }


    //Add ticket method for vendors to use
    public synchronized void addTicket(Ticket ticket) {
        while (ticketsList.size() >= maximumCapacity) {
            try{
                System.out.println("Ticket Pool is full..Please wait");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }

        }
        ticketsList.add(ticket);
        ticketPoolId++;
        System.out.println(ticket+"Ticket added to the pool");
        notifyAll(); //notifying waiting threads
    }

    //Buy ticked method for customers to use
    public synchronized Ticket buyTicket() {
        while(ticketsList.isEmpty()){
            try{
                System.out.println("Ticket Pool is empty.Please wait for tickets");
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket=ticketsList.removeFirst();
        System.out.println(ticket+"Ticket bought from pool");
        notifyAll(); //Notifying waiting threads
        return ticket;
    }

    //A method to get the current size of the pool
    public synchronized int getAvailableTickets() {
        return ticketsList.size();
    }

}
