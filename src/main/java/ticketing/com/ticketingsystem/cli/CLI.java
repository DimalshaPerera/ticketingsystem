package ticketing.com.ticketingsystem.cli;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        System.out.println("Welcome to ticketing system");
        boolean isAValidInput = true;
        try (Scanner input = new Scanner(System.in)) {
            while (isAValidInput) {
                System.out.println("enter y to continue or q to exist...");
                String choice = input.nextLine().trim();
                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Exiting the system...");
                    System.exit(0);
                } else if (choice.equalsIgnoreCase("y")) {
                    isAValidInput = false;
                    StartTicketingSystem(input);
                } else {
                    System.out.println("Invalid choice please try again");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static void StartTicketingSystem(Scanner input) {
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

                Configuration configuration = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
                configuration.saveFile("configuration.json");
                Configuration loadedConfiguration = Configuration.loadFile("configuration.json");

                if (loadedConfiguration != null) {
                    System.out.println("Loading Configuration from JSON:");
                    System.out.println("Total Tickets: " + loadedConfiguration.getTotalTickets());
                    System.out.println("Ticket Release Rate: " + loadedConfiguration.getTicketReleaseRate());
                    System.out.println("Customer Retrieval Rate: " + loadedConfiguration.getCustomerRetrievalRate());
                    System.out.println("Max Ticket Capacity: " + loadedConfiguration.getMaxTicketCapacity());
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println(" Please enter a valid integer.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                e.printStackTrace();
            }
        }

    }

    private static int getValidInteger(Scanner input) {
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


