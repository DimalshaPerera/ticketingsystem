package ticketing.com.ticketingsystem.controllers;

import org.springframework.web.bind.annotation.*;
import ticketing.com.ticketingsystem.cli.CLI;
import ticketing.com.ticketingsystem.cli.Configuration;

@RestController
@RequestMapping("/api/config")
@CrossOrigin(origins = "http://localhost:5175")  //my react port
public class ConfigController {
    private final CLI cli;
    private Configuration currentConfig;

    public ConfigController(CLI cli) {
        this.cli = cli;
        // Loading  configuration
        this.currentConfig = Configuration.loadFile("configuration.json");

    }

    @GetMapping
    public Configuration getConfig() {
        this.currentConfig = Configuration.loadFile("configuration.json");
        return currentConfig;
    }

    @PostMapping("/update")
    public Configuration updateConfig(@RequestBody Configuration newConfig) {
        newConfig.saveFile("configuration.json");
        this.currentConfig = newConfig;
        return newConfig;
    }
}
