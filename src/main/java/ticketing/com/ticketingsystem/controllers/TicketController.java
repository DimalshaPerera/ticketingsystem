package ticketing.com.ticketingsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ticketing.com.ticketingsystem.services.TicketService;

@RestController
public class TicketController {
    final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("ok")
    public String ok() {
        return "ok";
    }

}
