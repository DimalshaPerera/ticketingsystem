package ticketing.com.ticketingsystem.services;

import org.springframework.stereotype.Service;
import ticketing.com.ticketingsystem.models.TicketPool;
import ticketing.com.ticketingsystem.repositories.TicketPoolRepository;

import java.util.List;

@Service
public class TicketPoolService {
    private TicketPoolRepository ticketPoolRepository;

    public TicketPoolService(TicketPoolRepository ticketPoolRepository) {
        this.ticketPoolRepository = ticketPoolRepository;
    }

    public TicketPool saveTicketPool(TicketPool ticketPool) {
        return ticketPoolRepository.save(ticketPool);
    }

    public List<TicketPool> getAllTicketPools() {
        return ticketPoolRepository.findAll();
    }


}
