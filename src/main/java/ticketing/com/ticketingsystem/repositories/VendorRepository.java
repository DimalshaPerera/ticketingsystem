package ticketing.com.ticketingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketing.com.ticketingsystem.models.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
