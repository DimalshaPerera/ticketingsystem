package ticketing.com.ticketingsystem.models;

import jakarta.persistence.*;
import ticketing.com.ticketingsystem.repositories.TicketRepository;
import ticketing.com.ticketingsystem.services.TicketService;

import java.math.BigDecimal;


@Entity
public class Vendor implements Runnable{
    @Id
    @GeneratedValue
    private  long vendorId;
    @ManyToOne
    @JoinColumn
    private TicketPool ticketPool;
    private int totalTickets; // total tickets vendors will sell
    private int ticketReleaseRate;  //frequency of tickets getting added

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public Vendor() {}

    public Vendor( TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {

        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public void run(){
        for (int i = 0; i < totalTickets; i++) {
                Ticket ticket = new Ticket("Spandana", new BigDecimal("1000"), "2024-12-15", "Havelock grounds");
//                ticket=TicketService.saveTicket(ticket);
                ticketPool.addTicket(ticket);

                try {
                    Thread.sleep(ticketReleaseRate*1000);
                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e.getMessage());
                }
          }
        }
}
