package ticketing.com.ticketingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketing.com.ticketingsystem.models.TicketPool;

public interface TicketPoolRepository extends JpaRepository<TicketPool, Integer> {
}
