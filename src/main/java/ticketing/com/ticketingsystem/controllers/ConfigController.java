package ticketing.com.ticketingsystem.controllers;

import org.springframework.web.bind.annotation.*;
import ticketing.com.ticketingsystem.cli.CLI;
import ticketing.com.ticketingsystem.cli.Configuration;

@RestController
@RequestMapping("/api/config")
@CrossOrigin(origins = "http://localhost:5176")  // Make sure this matches your frontend port
public class ConfigController {
    private final CLI cli;
    private Configuration currentConfig;

    public ConfigController(CLI cli) {
        this.cli = cli;
        // Loading  configuration
        this.currentConfig = Configuration.loadFile("configuration.json");
        //creating a default one if the file doesn't have any data
        if (this.currentConfig == null) {
            this.currentConfig = new Configuration(10,10,10,10);
        }
        System.out.println("Current config: " + currentConfig); 
    }

    @GetMapping
    public Configuration getConfig() {
        System.out.println("Sending config: " + currentConfig);
        return currentConfig;
    }

    @PostMapping("/update")
    public Configuration updateConfig(@RequestBody Configuration newConfig) {
        newConfig.saveFile("configuration.json");
        this.currentConfig = newConfig;
        return newConfig;
    }
}
