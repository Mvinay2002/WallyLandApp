package App;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import model.TicketingBooth;
import model.EmergencyServices;
import model.Restaurant;
import view.TicketingBoothView;
import view.EmergencyServicesView;
import view.MainView;
import view.RestaurantView;
import controller.wallyLandApp;

/**
 * Holds all required information to get the default UI to be visible to the user
 * @author Maddie/Ben/Vinay
 */
public class App {
    public static void main(String[] args) {
        // Models
        TicketingBooth ticketModel = new TicketingBooth();
        EmergencyServices emergencyModel = new EmergencyServices("1-800-555-1234");
        Restaurant restaurantModel = new Restaurant("WallyLand Diner", 250, "Sample Menu");

        // Views
        TicketingBoothView ticketView = new TicketingBoothView(ticketModel.getEvents());
        EmergencyServicesView emergencyView = new EmergencyServicesView();
        RestaurantView restaurantView = new RestaurantView();
        MainView main = new MainView(); // The view that holds all buttons to get to different screens

        // Controller
        wallyLandApp controller = new wallyLandApp(
                ticketModel,
                emergencyModel,
                restaurantModel,
                main,
                ticketView,
                emergencyView,
                restaurantView
        );

        main.setVisible(true);
    }
}
