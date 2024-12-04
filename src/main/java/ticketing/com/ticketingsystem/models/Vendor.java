package ticketing.com.ticketingsystem.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



public class Vendor implements Runnable{
    private @Id
    @GeneratedValue long ticketId;
    private TicketPool ticketPool;
    private int totalTickets; // total tickets vendors will sell
    private int ticketReleaseRate;  //frequency of tickets getting added

    public Vendor(long ticketId, TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {
        this.ticketId = ticketId;
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public void run(){
        for (int i = 0; i < totalTickets; i++) {
//                Ticket ticket = new Ticket(, eventName, ticketPrice, eventDate, eventVenue, true);
//                ticketPool.addTicket(ticket);
//                System.out.println("Vendor added: " + ticket);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    System.out.println("Vendor interrupted");
//                }
          }
        }
}
