package ticketing.com.ticketingsystem.models;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class Vendor implements Runnable{
    @Id
    @GeneratedValue
    private  long vendorId;
    @ManyToOne
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



    public void run(){
        for (int i = 0; i < totalTickets; i++) {
                Ticket ticket = new Ticket("Spandana", new BigDecimal("1000"), "2024-12-15", "Havelock grounds");
                ticketPool.addTicket(ticket);
                System.out.println("Vendor added: " + ticket);
                try {
                    Thread.sleep(ticketReleaseRate*1000);
                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e.getMessage());
                }
          }
        }
}
