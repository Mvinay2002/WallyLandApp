package controller;

import model.TicketingBooth;
import model.EmergencyServices;
import model.Restaurant;
import view.TicketingBoothView;
import view.EmergencyServicesView;
import view.RestaurantView;
import view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * To act as the controller in the MVC architecture.
 * - All functions will eventually be passed through here with user inputs.
 * @author Maddie/Ben/Vinay
 */
public class wallyLandApp {

    // Fields
    final TicketingBooth ticketModel;
    final EmergencyServices emergencyModel;
    final Restaurant restaurantModel; // Added Restaurant model
    final MainView main;
    final TicketingBoothView ticketView;
    final EmergencyServicesView emergencyView;
    final RestaurantView restaurantView; // Added Restaurant view
    private double totalPrice = 0;

    // Constructor
    public wallyLandApp(TicketingBooth ticketModel, EmergencyServices emergencyModel, Restaurant restaurantModel,
                        MainView main, TicketingBoothView ticketView, EmergencyServicesView emergencyView, RestaurantView restaurantView) {
        this.ticketModel = ticketModel;
        this.emergencyModel = emergencyModel;
        this.restaurantModel = restaurantModel;
        this.main = main;
        this.ticketView = ticketView;
        this.emergencyView = emergencyView;
        this.restaurantView = restaurantView;

        // Main View button listeners
        this.main.addTicketingBoothButtonListener(e -> showTicketingBoothView());
        this.main.addEmergencyServicesButtonListener(e -> showEmergencyServicesView());
        this.main.addRestaurantButtonListener(e -> showRestaurantView()); // Added listener for Restaurant

        // Ticketing Booth View button listeners
        this.ticketView.setSeeAvailableButtonListener(new OrderButtonListener());
        this.ticketView.setCancelButtonListener(new CancelButtonListener());
        this.ticketView.setPayButtonListener(new PayButtonListener());
        this.ticketView.setBackButtonListener(e -> showMainView());

        // Emergency Services View button listeners
        this.emergencyView.setReportButtonListener(new ReportMissingChildListener());
        this.emergencyView.setBackButtonListener(e -> showMainView());

        // Restaurant View button listeners
        this.restaurantView.setReserveButtonListener(new ReserveTableListener());
        this.restaurantView.setAvailabilityButtonListener(new CheckAvailabilityListener());
        this.restaurantView.setMenuButtonListener(new ViewMenuListener());
        this.restaurantView.setBackButtonListener(e -> showMainView());
    }

    // Methods to show views
    private void showTicketingBoothView() {
        main.setVisible(false);
        ticketView.setVisible(true);
    }

    private void showEmergencyServicesView() {
        main.setVisible(false);
        emergencyView.setVisible(true);
    }

    private void showRestaurantView() { // Show Restaurant view
        main.setVisible(false);
        restaurantView.setVisible(true);
    }

    private void showMainView() {
        ticketView.setVisible(false);
        emergencyView.setVisible(false);
        restaurantView.setVisible(false); // Reset Restaurant view visibility
        main.setVisible(true);
    }

    /**
     * When the order Button (seen as "See Available Tickets and Prices" button on the UI)
     * is pressed, the event name and party size are used and input into the orderTickets
     * method from the TicketingBooth class. The user is then given the total price for an order
     * of their requested size.
     */
    class OrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String eventName = ticketView.getSelectedEventName();
            int partySize = ticketView.getPartySize();

            String result = ticketModel.orderTickets(partySize, eventName);

            if (result.startsWith("Total price")) {
                // take the total price from the result string and leave behind the rest of the string
                totalPrice = Double.parseDouble(result.replaceAll("[^0-9.]", ""));
            } else {
                totalPrice = 0; // Reset totalPrice if order was not successful
            }

            ticketView.displayMessage(result);
        }
    }

    /**
     * When the cancel button is pressed, any previously made order is reversed, and the
     * number of tickets is made available again to the next user.
     */
    class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ticketView.clearMessages();
            String selectedEvent = ticketView.getSelectedEventName();
            int partySize = ticketView.getPartySize();

            if (partySize > 0) {
                String result = ticketModel.cancelOrder(partySize, selectedEvent);
                ticketView.displayMessage(result);
            } else {
                ticketView.displayMessage("Please enter a valid party size.");
            }
        }
    }

    /**
     * When the pay button is pressed, the most recently requested order
     * is placed, and that number of tickets is then removed from the availability for that event.
     */
    class PayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ticketView.clearMessages();
            if (totalPrice > 0) {
                String paymentConfirmation = ticketModel.payFee(totalPrice);
                ticketView.displayMessage(paymentConfirmation);
                totalPrice = 0; // Reset total price after payment
            } else {
                ticketView.displayMessage("Please place an order before paying.");
            }
        }
    }

    /**
     * Event listener for EmergencyServicesView - Report Missing Child
     */
    class ReportMissingChildListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String childName = emergencyView.getChildName();

            if (childName.isEmpty()) {
                emergencyView.displayMessage("Error: Child's name cannot be empty.");
                return;
            }

            String emergencyPhone = emergencyModel.requestMissingChildReport(childName);
            emergencyView.displayMessage("A report has been filed for: " + childName);
            emergencyView.displayMessage("Contact the emergency line: " + emergencyPhone);
        }
    }

    // Event listener for RestaurantView - Reserve Table
    class ReserveTableListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int tables = restaurantView.getNumberOfTables();
            if (tables > 0 && restaurantModel.makeReservation(tables)) {
                restaurantView.displayMessage("Reservation successful for " + tables + " tables.");
            } else {
                restaurantView.displayMessage("Reservation failed. Not enough tables available.");
            }
        }
    }

    // Event listener for RestaurantView - Check Table Availability
    class CheckAvailabilityListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int availableTables = restaurantModel.checkAvailability();
            restaurantView.displayMessage("Available tables: " + availableTables);
        }
    }

    // Event listener for RestaurantView - View Menu
    class ViewMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = restaurantModel.getMenu();
            restaurantView.displayMessage("Menu:\n" + menu);
        }
    }
}
