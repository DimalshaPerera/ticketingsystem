package ticketing.com.ticketingsystem.services;

import org.springframework.stereotype.Service;
import ticketing.com.ticketingsystem.models.Ticket;
import ticketing.com.ticketingsystem.repositories.TicketRepository;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }



}
