package ticketing.com.ticketingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.Persistent;
import ticketing.com.ticketingsystem.repositories.TicketRepository;
import ticketing.com.ticketingsystem.services.TicketService;
import ticketing.com.ticketingsystem.services.VendorService;

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
    @Transient //dont save to the database and is used only in the application for ticket-related operations.
    private TicketService ticketService;

    @Transient
    private VendorService vendorService;



    public Vendor() {}

    public Vendor( TicketPool ticketPool, int totalTickets, int ticketReleaseRate, TicketService ticketService, VendorService vendorService ) {

        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketService = ticketService;
        this.vendorService = vendorService;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }



    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @JsonIgnore
    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public void run(){
        for (int i = 0; i < totalTickets; i++) {
                Ticket ticket = new Ticket("Spandana", new BigDecimal("1000"), "2024-12-15", "Havelock grounds");
                ticket=ticketService.saveTicket(ticket);
                ticketPool.addTicket(ticket);
                vendorService.saveVendor(this);

                try {
                    Thread.sleep(ticketReleaseRate*1000);
                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e.getMessage());
                }
          }
        }
}
