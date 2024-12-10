package ticketing.com.ticketingsystem.services;

import org.springframework.stereotype.Service;
import ticketing.com.ticketingsystem.models.TicketPool;
import ticketing.com.ticketingsystem.models.Vendor;
import ticketing.com.ticketingsystem.repositories.VendorRepository;

import java.util.List;


@Service
public class VendorService {
    private final VendorRepository vendorRepository;
    private final TicketService ticketService;


    public VendorService(VendorRepository vendorRepository, TicketService ticketService) {
        this.vendorRepository = vendorRepository;
        this.ticketService = ticketService;

    }
    // Save a vendor
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Getting all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public void StartVendorThreads(TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {
        Vendor[] vendors = new Vendor[10];		//Array of vendors

        for(int i=0; i<vendors.length; i++){
            vendors[i] = new Vendor(ticketPool,totalTickets,ticketReleaseRate,ticketService,this);
            saveVendor(vendors[i]);
            Thread vendorThread = new Thread(vendors[i],"Vendor: "+i);
            vendorThread.start();
        }
    }



}
