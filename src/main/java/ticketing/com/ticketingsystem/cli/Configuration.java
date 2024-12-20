package ticketing.com.ticketingsystem.cli;

import com.google.gson.Gson;

import java.io.*;

public class Configuration implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private int numOfCustomers;
    private int numOfVendors;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity, int numOfCustomers, int numofVendors) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
        this.numOfCustomers = numOfCustomers;
        this.numOfVendors = numofVendors;
    }

    //Getters and setters
    public int getTotalTickets() {
        return totalTickets;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }
    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }
    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }
    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getNumOfCustomers() {
        return numOfCustomers;
    }

    public void setNumOfCustomers(int numOfCustomers) {
        this.numOfCustomers = numOfCustomers;
    }

    public int getNumOfVendors() {
        return numOfVendors;
    }

    public void setNumOfVendors(int numOfVendors) {
        this.numOfVendors = numOfVendors;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                ", numOfCustomers=" + numOfCustomers +
                ", numOfVendors=" + numOfVendors +
                '}';
    }


    public void saveFile(String filename) {
        try(Writer writer = new FileWriter(filename)) {
            Gson gson = new Gson();
            gson.toJson(this,writer);
            System.out.println("Configuration saved successfully to " + filename);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Configuration loadFile(String filename) {
        try(Reader reader= new FileReader(filename)){
            Gson gson = new Gson();
            return gson.fromJson(reader, Configuration.class);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
