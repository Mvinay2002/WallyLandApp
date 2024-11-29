/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Events;
import java.util.logging.Logger;
/**
 * The UI for the Ticketing Booth. Here, users can find information regarding ticket availability.
 * They can also pay for an order or cancel their most recent purchase
 * @author Maddie
 */
public class TicketingBoothView extends JFrame{
    
    //fields
    final JComboBox<String> eventOptions;
    final JTextField partySizeInput;
    final JButton seeAvailableButton;
    final JButton cancelButton;
    final JButton payButton;
    final JTextArea textOutput;
    final JLabel partySizeLabel;
    private final JButton backButton;
    
    private static final Logger ERR = Logger.getLogger
        (TicketingBoothView.class.getName());//used for a try/catch error in getPartySize method
    
    //constructor
    /**
     * constructor used to implement desired items into frame
     * @param events list of events for user to learn more about
     */
    public TicketingBoothView(ArrayList<Events> events)
    {
        setTitle("Ticketing Booth");
        setSize(700, 225);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
       
        //initializing all features on the screen
        eventOptions = new JComboBox<>();
        partySizeInput = new JTextField(5);
        seeAvailableButton = new JButton("See Available Tickets and Prices");
        cancelButton = new JButton("Cancel Last Order");
        payButton = new JButton("Pay for Order");
        textOutput = new JTextArea(5,30);
        textOutput.setEditable(false);
        partySizeLabel = new JLabel("Enter Party Size: ");
        backButton = new JButton("Back to Main Menu");
        
        
        
        for (Events event: events)
        {
            eventOptions.addItem(event.getEventName());//adding each event from the TicketingBooth class to the dropdown menu
        }
        
        JPanel topPanel = new JPanel();// creating separation between what should be show on the top of the screen vs 
        //the bottom or center of the screen
        
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("Select Event: "));
        topPanel.add(eventOptions);topPanel.add(partySizeLabel);topPanel.add(partySizeInput);
        topPanel.setBackground(Color.pink);
        add(topPanel, BorderLayout.NORTH);//adding topPanel to the top
        
        
        JPanel centerPanel = new JPanel(); //items that should be shown in the middle of the screen
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(seeAvailableButton);centerPanel.add(payButton);centerPanel.add(cancelButton);centerPanel.add(backButton);
        centerPanel.setBackground(Color.pink);
        add(centerPanel, BorderLayout.CENTER); //center panel put in place
        
        
        JPanel output = new JPanel();
        output.setLayout(new BorderLayout());
        JScrollPane scroller = new JScrollPane(textOutput);
        output.add(scroller, BorderLayout.CENTER);
        add(output, BorderLayout.SOUTH); //one item for the bottom of the screen
        
    }
    /**
     * Taking the input from the drop down menu
     * @return the name of the selected event
     */
    public String getSelectedEventName()
    {
        String selectedEvent = (String) eventOptions.getSelectedItem();
        return selectedEvent;
    }
    
    /**
     * taking the input from the party size text field
     * @return number of requested tickets
     */
    public int getPartySize()
    {
        try{
            int partySize = Integer.parseInt(partySizeInput.getText());
            return partySize;
        } catch (IllegalArgumentException e)
        {
                ERR.warning("Invalid party size input.");
                return 0;//default int if invalid
        }
    }
    
    //listeners
    
    /**
     * providing availability Button with functionality
     * @param listener responds to button click
     */
    public void setSeeAvailableButtonListener(ActionListener listener)
        {
            seeAvailableButton.addActionListener(listener);
        }
    
    /**
     * providing cancel Button with functionality
     * @param listener responds to button click
     */
    public void setCancelButtonListener(ActionListener listener)
    {
        cancelButton.addActionListener(listener);
    }
    
    /**
     * providing pay Button with functionality
     * @param listener responds to button click
     */
    public void setPayButtonListener(ActionListener listener)
    {
        payButton.addActionListener(listener);
    }
    
    /**
     * providing proper layout of message to be displayed, 
     * allowing next message to be placed on the following line
     * @param message message to be shown to user
     */
    public void displayMessage(String message)
    {
        textOutput.append(message + "\n");
    }
    
    /**
     * clears text box of previous messages
     */
    public void clearMessages()
    {
        textOutput.setText("");
    }
    
    public void setBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
