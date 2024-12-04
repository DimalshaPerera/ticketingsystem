package ticketing.com.ticketingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Ticket {
    private @Id @GeneratedValue long ticketId;
    private String eventName;
    private BigDecimal ticketPrice;
    private String eventDate;
    private String eventVenue;
    private boolean ticketStatus; // true = available, false = sold out

    public Ticket() {}

    //Constructor
    public Ticket( String eventName, BigDecimal ticketPrice, String eventDate, String eventVenue) {

        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.ticketStatus = true;
    }

    //setters and getters
    public long getTicketId() {
        return ticketId;
    }
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public boolean isTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", eventName='" + eventName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", eventDate='" + eventDate + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                '}';
    }

}
