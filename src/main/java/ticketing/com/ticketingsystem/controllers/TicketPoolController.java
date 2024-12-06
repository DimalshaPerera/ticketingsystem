package ticketing.com.ticketingsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ticketing.com.ticketingsystem.models.TicketPool;
import ticketing.com.ticketingsystem.services.TicketPoolService;

@RestController
public class TicketPoolController {
       private TicketPoolService ticketPoolService;
       public TicketPoolController(TicketPoolService ticketPoolService) {
           this.ticketPoolService = ticketPoolService;
       }
    @GetMapping("/testing-tp")
    public String test() {return "API IS WORKING ";}

}
