package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
/**
 * The ActivityScheduler class allows users to manage activity reservations. 
 * Users can add, change, or remove reservations and also view available events.
 * 
 * <p>This class handles basic functionality such as checking availability of events
 * and managing user-specific activity schedules.</p>
 * 
 * @author Maddie
 */
public class ActivityScheduler {
 
    /** 
     * Stores the scheduled activities for each user. 
     * The key is the user's name, and the value is a list of activities.
     */
    private HashMap<String, List<String>> userActivities;
 
    /** 
     * Stores the available activities that can be reserved. 
     */
    private List<String> availableActivities;
 
    /**
     * Constructs an ActivityScheduler with a predefined list of available activities.
     * Initializes the userActivities map and adds default activities to the availableActivities list.
     */
    public ActivityScheduler() {
        // Constructor implementation goes here
    }
 
    /**
     * Adds a new activity to the user's schedule if the activity is available.
     * 
     * @param user the name of the user
     * @param activity the activity to be added
     */
    public void addActivity(String user, String activity) {
        // Code for adding an activity goes here
    }
 
    /**
     * Changes an existing activity reservation for the user.
     * 
     * @param user the name of the user
     * @param oldActivity the current activity in the user's schedule
     * @param newActivity the new activity to replace the old one
     */
    public void changeActivity(String user, String oldActivity, String newActivity) {
        // Code for changing an activity goes here
    }
 
    /**
     * Removes an existing activity reservation from the user's schedule.
     * 
     * @param user the name of the user
     * @param activity the activity to be removed
     */
    public void removeActivity(String user, String activity) {
        // Code for removing an activity goes here
    }
 
    /**
     * Displays the list of activities currently available for reservation.
     */
    public void displayAvailableActivities() {
        // Code for displaying available activities goes here
    }
 
    /**
     * Displays the activities that the specified user has reserved.
     * 
     * @param user the name of the user
     */
    public void displayUserActivities(String user) {
        // Code for displaying user activities goes here
    }
}
