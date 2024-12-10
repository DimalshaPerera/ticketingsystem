//package ticketing.com.ticketingsystem.controllers;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import ticketing.com.ticketingsystem.cli.Configuration;
//import ticketing.com.ticketingsystem.cli.CLI;
//
//@Controller
//public class WebSocketController {
//    private final SimpMessagingTemplate messagingTemplate;
//    private final CLI cli;
//    private Configuration currentConfig;
//
//    public WebSocketController(SimpMessagingTemplate messagingTemplate, CLI cli) {
//        this.messagingTemplate = messagingTemplate;
//        this.cli = cli;
//        // Load saved configuration if it exists
//        this.currentConfig = Configuration.loadFile("configuration.json");
//    }
//
//    @MessageMapping("/config/request")
//    @SendTo("/topic/config")
//    public Configuration getConfig() {
//        return currentConfig;
//    }
//
//    @MessageMapping("/config/update")
//    @SendTo("/topic/config")
//    public Configuration updateConfig(Configuration newConfig) {
//        // Save the new configuration
//        newConfig.saveFile("configuration.json");
//        this.currentConfig = newConfig;
//        return newConfig;
//    }
//
//    // Method for server to push updates to clients
//    public void sendConfigUpdate(Configuration config) {
//        this.currentConfig = config;
//        messagingTemplate.convertAndSend("/topic/config", config);
//    }

    // Optional: Method to start CLI and get new configuration
//    public void startCLI() {
//        Configuration cliConfig = cli.start();
//        if (cliConfig != null) {
//            this.currentConfig = cliConfig;
//            sendConfigUpdate(cliConfig);
//        }
//    }
