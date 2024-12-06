package ticketing.com.ticketingsystem.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import ticketing.com.ticketingsystem.models.TicketPool;
import ticketing.com.ticketingsystem.models.Vendor;
import ticketing.com.ticketingsystem.repositories.VendorRepository;

import java.util.List;


@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;

    }
    // Save a vendor
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Getting all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }



}
