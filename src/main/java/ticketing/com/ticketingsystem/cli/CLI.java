package ticketing.com.ticketingsystem.cli;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class CLI {
    public Configuration start(){
        boolean isAValidInput = true;
        Configuration configuration=null;
        System.out.println("Welcome to the ticketing system!");
        try (Scanner input = new Scanner(System.in)) {
            while (isAValidInput) {
                System.out.println("enter y to continue or q to exist...");
                String choice = input.nextLine().trim();
                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Exiting the system...");
                    System.exit(0);
                } else if (choice.equalsIgnoreCase("y")) {
                    isAValidInput = false;
                    configuration = StartTicketingSystem(input);
                } else {
                    System.out.println("Invalid choice please try again");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } return configuration;

    }

    private Configuration StartTicketingSystem(Scanner input) {
        while (true) {
            try {
                System.out.print("Enter Total number of tickets: ");
                int totalTickets = getValidInteger(input);
                System.out.print("Enter Ticket Release rate: ");
                int ticketReleaseRate = getValidInteger(input);
                System.out.print("Enter Customer Retrieval Rate : ");
                int customerRetrievalRate = getValidInteger(input);
                System.out.print("Enter maximum ticket capacity:");
                int maxTicketCapacity = getValidInteger(input);
                System.out.print("Enter the number of customers:");
                int numOfCustomers = getValidInteger(input);
                System.out.println("Enter the number of Vendors:");
                int numOfVendors = getValidInteger(input);

                Configuration configuration = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity, numOfCustomers, numOfVendors);
                configuration.saveFile("configuration.json");
                return configuration;

            } catch (InputMismatchException e) {
                System.out.println(" Please enter a valid integer.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                e.printStackTrace();
            }
        }

    }

    private  int getValidInteger(Scanner input) {
        int number;
        while (true) {
            try {
                number = input.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("Invalid input. Please enter a positive integer: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
                input.nextLine();
            }
        }
    }
}


