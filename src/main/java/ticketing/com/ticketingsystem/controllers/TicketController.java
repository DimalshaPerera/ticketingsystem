package ticketing.com.ticketingsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ticketing.com.ticketingsystem.models.Ticket;
import ticketing.com.ticketingsystem.services.TicketService;

import java.util.List;

@RestController
public class TicketController {
    final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("tickets")
    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

}
