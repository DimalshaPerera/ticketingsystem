package ticketing.com.ticketingsystem.models;

import jakarta.persistence.*;
import ticketing.com.ticketingsystem.services.TicketService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;

@Entity
public class TicketPool {
    @Id @GeneratedValue
    private long ticketPoolId;
    @OneToMany // A TicketPool can have many Tickets.
    private List<Ticket> ticketsList;
    private int maximumCapacity;
    @Transient private TicketService ticketService;


    public TicketPool() {}

    public TicketPool(int maximumCapacity, TicketService ticketService) {
        this.maximumCapacity = maximumCapacity;
        this.ticketsList= Collections.synchronizedList(new ArrayList<>());
        this.ticketService = ticketService;
    }
    // Setter for ticketService
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
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
        notifyAll(); //notifying waiting threads
        System.out.println(Thread.currentThread().getName()+" added "+ticket+ " to the pool and the current size is "+ticketsList.size());



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
        Ticket ticket=ticketsList.remove(0);
        ticket.setTicketStatus("Sold");
        // Save the updated ticket status to database
        if (ticketService != null) {
            ticket = ticketService.saveTicket(ticket);
        }
        notifyAll(); //Notifying waiting threads
        System.out.println( Thread.currentThread().getName()+" has bought ticket "+ticket+ " and the current size is "+ticketsList.size());

        return ticket;
    }

    //A method to get the current size of the pool
    public synchronized int getAvailableTickets() {

        return ticketsList.size();

    }

}
