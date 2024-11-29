/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * The UI for Emergency Services in WallyLand.
 * Users can report a missing child and get emergency contact information.
 * Provides navigation back to the Main Menu.
 * 
 * @author Ben Barone
 */
public class EmergencyServicesView extends JFrame {
    
    // Fields for UI components
    private final JTextField childNameInput;
    private final JButton reportButton;
    private final JButton backButton;
    private final JTextArea textOutput;
    private final JLabel childNameLabel;

    private static final Logger ERR = Logger.getLogger(EmergencyServicesView.class.getName()); // For logging errors

    // Constructor
    /**
     * Constructor to initialize and arrange UI components.
     */
    public EmergencyServicesView() {
        setTitle("Emergency Services");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize UI components
        childNameInput = new JTextField(20);
        reportButton = new JButton("Report Missing Child");
        backButton = new JButton("Back to Main Menu");
        textOutput = new JTextArea(5, 30);
        textOutput.setEditable(false);
        childNameLabel = new JLabel("Enter Child's Name: ");

        // Top Panel for input
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(childNameLabel);
        topPanel.add(childNameInput);
        topPanel.setBackground(Color.cyan);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel for buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(reportButton);
        centerPanel.add(backButton);
        centerPanel.setBackground(Color.cyan);
        add(centerPanel, BorderLayout.CENTER);

        // Output Panel for displaying results
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        JScrollPane scroller = new JScrollPane(textOutput);
        outputPanel.add(scroller, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }

    // Getters for UI components

    /**
     * Get the entered child's name from the text field.
     * 
     * @return The entered child's name.
     */
    public String getChildName() {
        return childNameInput.getText().trim();
    }

    // Listeners

    /**
     * Adds a listener to the report button.
     * 
     * @param listener ActionListener to handle button clicks.
     */
    public void setReportButtonListener(ActionListener listener) {
        reportButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the back button.
     * 
     * @param listener ActionListener to handle button clicks.
     */
    public void setBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    // Output display

    /**
     * Displays a message in the output text area.
     * 
     * @param message Message to display.
     */
    public void displayMessage(String message) {
        textOutput.append(message + "\n");
    }

    /**
     * Clears the output text area.
     */
    public void clearMessages() {
        textOutput.setText("");
    }
}
