package ticketing.com.ticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ticketing.com.ticketingsystem.models.Customer;
import ticketing.com.ticketingsystem.models.TicketPool;
import ticketing.com.ticketingsystem.models.Vendor;

@SpringBootApplication
public class TicketingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingsystemApplication.class, args);
		TicketPool ticketPool = new TicketPool();
		Vendor[] vendors = new Vendor[10]; // Array of Vendors
		for(int i=0; i<vendors.length; i++){
			vendors[i] = new Vendor();
			Thread vendorThread = new Thread(vendors[i],"Vendor: "+i);
			vendorThread.start();
		}

		Customer[] customers = new Customer[10];
		for(int i=0; i<customers.length; i++){
			customers[i] = new Customer();
			Thread customerThread = new Thread(customers[i],"Customer: "+i);
			customerThread.start();
		}


	}

}
