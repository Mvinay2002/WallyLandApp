/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *the Main view is the default UI that the user is brought to. 
     * Here, the user will see four button options, which will all bring the user to a different screen.
     * each button has it's own UI design that is then called and then presented to the user
 * @author Maddie/Ben
 */
public class MainView extends JFrame{
    
    //fields
    final JButton ticketingBoothButton;
    final JButton activitySchedulerButton;
    final JButton emergencyServicesButton;
    final JButton restaurantButton;
    
    //constructor
    /**
     * constructor to set general information about the frame
     * ,hard-coded buttons into place
     */
    public MainView(){
        //adding general information to the view
    this.setTitle("Wally Land Vacation Planner");
    this.setSize(500, 300);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    ticketingBoothButton = new JButton("Go to Ticketing Booth");
    ticketingBoothButton.setBackground(Color.pink);
    activitySchedulerButton = new JButton("Go to Activity Scheduler");
    activitySchedulerButton.setBackground(Color.pink);
    emergencyServicesButton = new JButton("Go to Emergency Services");
    emergencyServicesButton.setBackground(Color.pink);
    restaurantButton = new JButton("Go to Restaurant");
    restaurantButton.setBackground(Color.pink);
    
    JPanel buttonGroup = new JPanel(new GridLayout(2, 2, 10, 10));//forming buttons into desired square layout
    buttonGroup.setBackground(Color.DARK_GRAY);
    
    buttonGroup.add(ticketingBoothButton);
    buttonGroup.add(activitySchedulerButton);
    buttonGroup.add(emergencyServicesButton);
    buttonGroup.add(restaurantButton);
    
    this.add(buttonGroup);
    
    this.setVisible(true);
    
    }
    
    
    //listeners
    /**
     * providing Ticketing Booth Button with functionality
     * @param listener responds to button click
     */
    public void addTicketingBoothButtonListener(ActionListener listener)
    {
    ticketingBoothButton.addActionListener(listener);
    }
    
    /**
     * providing Activity Scheduler Button with functionality
     * @param listener responds to button click
     */
    public void addActivitySchedulerButtonListener(ActionListener listener)
    {
    activitySchedulerButton.addActionListener(listener);
    }
    
    /**
     * providing emergency services Button with functionality
     * @param listener responds to button click
     */
    public void addEmergencyServicesButtonListener(ActionListener listener)
    {
    emergencyServicesButton.addActionListener(listener);
    }
    
    
    /**
     * providing restaurant Button with functionality
     * @param listener responds to button click
     */
    public void addRestaurantButtonListener(ActionListener listener)
    {
    restaurantButton.addActionListener(listener);
    }
}
