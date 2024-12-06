package ticketing.com.ticketingsystem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ticketing.com.ticketingsystem.models.Vendor;
import ticketing.com.ticketingsystem.services.VendorService;

import java.util.List;

@RestController
public class VendorController {
    final private VendorService vendorService;
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/testing")
    public String test() {return "API IS WORKING ";}

    //Creating a new vendor
    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor saveVendor=vendorService.saveVendor(vendor);
        return ResponseEntity.ok().body(saveVendor);
    }

    // Get all vendors
    @GetMapping("/get-all-vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
}

