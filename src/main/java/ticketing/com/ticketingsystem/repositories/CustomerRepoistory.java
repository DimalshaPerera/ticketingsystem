package ticketing.com.ticketingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketing.com.ticketingsystem.models.Customer;

public interface CustomerRepoistory extends JpaRepository<Customer,Integer> {
}
