package ticketing.com.ticketingsystem.controllers;//package ticketing.com.ticketingsystem.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import ticketing.com.ticketingsystem.models.TicketPool;
//import ticketing.com.ticketingsystem.services.TicketPoolService;
//
//import java.util.List;
//
//@RestController
//public class TicketPoolController {
//       private TicketPoolService ticketPoolService;
//       public TicketPoolController(TicketPoolService ticketPoolService) {
//           this.ticketPoolService = ticketPoolService;
//       }
//    @GetMapping("/ticketPool")
//    public List<TicketPool> getAllTicketPool() {
//        return ticketPoolService.getAllTicketPools();
//    }
//
//}

import org.springframework.web.bind.annotation.*;
import ticketing.com.ticketingsystem.services.TicketPoolService;
import ticketing.com.ticketingsystem.models.TicketPool;

@RestController
@RequestMapping("/api/ticketpool")
@CrossOrigin(origins = "http://localhost:5175")
public class TicketPoolController {
    private final TicketPoolService ticketPoolService;

    public TicketPoolController(TicketPoolService ticketPoolService) {
        this.ticketPoolService = ticketPoolService;
    }


    public int getAvailableTickets() {
        TicketPool currentTicketPool=ticketPoolService.getAllTicketPools().getFirst();
        return ticketPoolService.getAvailableTickets(currentTicketPool);

    }
}
