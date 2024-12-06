package ticketing.com.ticketingsystem;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ticketing.com.ticketingsystem.cli.CLI;
import ticketing.com.ticketingsystem.cli.Configuration;
import ticketing.com.ticketingsystem.models.Customer;
import ticketing.com.ticketingsystem.models.TicketPool;
import ticketing.com.ticketingsystem.models.Vendor;
import ticketing.com.ticketingsystem.services.CustomerService;
import ticketing.com.ticketingsystem.services.TicketPoolService;
import ticketing.com.ticketingsystem.services.TicketService;
import ticketing.com.ticketingsystem.services.VendorService;


@SpringBootApplication
public class TicketingsystemApplication implements CommandLineRunner {
	private final CLI cli;
	private final VendorService vendorService;
	private final TicketPoolService ticketPoolService;
	private final TicketService ticketService;


	public TicketingsystemApplication(CLI cli, VendorService vendorService, TicketPoolService ticketPoolService, TicketService ticketService) {
		this.cli = cli;
		this.vendorService = vendorService;
        this.ticketPoolService = ticketPoolService;
        this.ticketService = ticketService;
    }
	public static void main(String[] args) {
		SpringApplication.run(TicketingsystemApplication.class, args);
	}
	@Override
	public void run(String... args) {
		System.out.println("Welcome to the ticketing system!");
		// Start CLI and get configuration
		Configuration configuration = cli.start();

		if (configuration != null) {
			System.out.println("Loaded configuration:");
//			System.out.println(configuration);

			// Use the configuration to initialize the system
			int maxTicketCapacity = configuration.getMaxTicketCapacity();
			int totalTickets=configuration.getTotalTickets();
			int ticketReleaseRate = configuration.getTicketReleaseRate();
			int customerRetrievalRate = configuration.getCustomerRetrievalRate();

			TicketPool ticketPool = new TicketPool(maxTicketCapacity);
			ticketPool = ticketPoolService.saveTicketPool(ticketPool);
			Vendor[] vendors = new Vendor[10];		//Array of vendors

			for(int i=0; i<vendors.length; i++){
				vendors[i] = new Vendor(ticketPool,totalTickets,ticketReleaseRate);
				vendorService.saveVendor(vendors[i]);
				Thread vendorThread = new Thread(vendors[i],"Vendor: "+i);
				vendorThread.start();
			}
			Customer[] customers = new Customer[10];//An array of customers
			for(int i=0; i<customers.length; i++){
				customers[i] = new Customer(i,ticketPool,customerRetrievalRate,20);
				Thread customerThread = new Thread(customers[i],"Customer: "+i);
				customerThread.start();
			}

	}else{
			System.out.println("No configuration loaded!");
			System.exit(0);
		}

}}
