package model;

/**
 * This class represents a Restaurant in the WallyLand theme park.
 * It handles table reservations, checking available tables, and showing the restaurant's menu so visitors are prepared with their order ahead of time.
 * @author: Vinay
 */
public class Restaurant {
    private String restaurantName; // Name of the restaurant
    private int availableTables;   // Number of tables currently available
    private String menu;           // The menu of the restaurant

    /**
     * This is the constructor for the Restaurant class.
     * It sets the restaurant name, number of available tables, and the menu.
     *
     * @param restaurantName The name of the restaurant
     * @param availableTables How many tables are available
     * @param menu The menu for the restaurant
     */
    public Restaurant(String restaurantName, int availableTables, String menu) {
        this.restaurantName = restaurantName;
        this.availableTables = availableTables;
        this.menu = generateMenu(); // Automatically generate the default menu
    }

    /**
     * Generates the default menu for all WallyLand restaurants.
     *
     * @return The default menu as a string
     */
    private String generateMenu() {
        return "Menu:\n"
                + "Classics:\n"
                + "1. Hotdog ($2.99)\n"
                + "2. Burger ($5.99)\n"
                + "3. 3p Chicken Tenders ($6.99)\n"
                + "4. Pizza Slice ($2.99)\n"
                + "5. Warm Pretzel ($1.99)\n\n"
                + "Beverages:\n"
                + "1. Coffee ($2.49)\n"
                + "2. Coke ($2.49)\n"
                + "3. Fanta ($2.49)\n"
                + "4. Sprite ($2.49)\n"
                + "5. Dr. Pepper ($2.49)\n"
                + "6. Water Bottle ($0.99)\n"
                + "7. Lemonade ($1.99)\n"
                + "8. Iced Tea ($1.99)";
    }

    /**
     * This method is used to make a reservation at the restaurant.
     *
     * @param numberOfTables The number of tables you want to reserve
     * @return true if the reservation is successful, false if there aren't enough tables
     */
    public boolean makeReservation(int numberOfTables) {
        if (numberOfTables <= availableTables) {
            availableTables -= numberOfTables; // Reduce available tables
            return true;  // Reservation successful
        }
        return false;  // Not enough tables
    }

    /**
     * This method checks how many tables are still available.
     *
     * @return The number of available tables
     */
    public int checkAvailability() {
        return availableTables;
    }

    /**
     * This method returns the restaurant's menu.
     *
     * @return The menu of the restaurant
     */
    public String getMenu() {
        return menu;
    }

    /**
     * This method gets the name of the restaurant.
     *
     * @return The name of the restaurant
     */
    public String getRestaurantName() {
        return restaurantName;
    }
}
