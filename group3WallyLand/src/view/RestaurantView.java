package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The UI for Restaurant in WallyLand.
 * Users can make reservations, check availability, and view the menu.
 * @author Vinay
 */
public class RestaurantView extends JFrame {

    private final JTextField tableInput;
    private final JButton reserveButton;
    private final JButton availabilityButton;
    private final JButton menuButton;
    private final JButton backButton;
    private final JTextArea textOutput;

    // Constructor
    public RestaurantView() {
        setTitle("Restaurant");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        tableInput = new JTextField(5);
        reserveButton = new JButton("Reserve Tables");
        availabilityButton = new JButton("Check Availability");
        menuButton = new JButton("View Menu");
        backButton = new JButton("Back to Main Menu");
        textOutput = new JTextArea(5, 30);
        textOutput.setEditable(false);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Number of Tables: "));
        inputPanel.add(tableInput);
        inputPanel.setBackground(Color.LIGHT_GRAY);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(reserveButton);
        buttonPanel.add(availabilityButton);
        buttonPanel.add(menuButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        // Output panel
        JPanel outputPanel = new JPanel();
        JScrollPane scroller = new JScrollPane(textOutput);
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(scroller, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }

    // Get user input for number of tables
    public int getNumberOfTables() {
        try {
            return Integer.parseInt(tableInput.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Display messages to the user
    public void displayMessage(String message) {
        textOutput.append(message + "\n");
    }

    // Clear output messages
    public void clearMessages() {
        textOutput.setText("");
    }

    // Add listeners for buttons
    public void setReserveButtonListener(ActionListener listener) {
        reserveButton.addActionListener(listener);
    }

    public void setAvailabilityButtonListener(ActionListener listener) {
        availabilityButton.addActionListener(listener);
    }

    public void setMenuButtonListener(ActionListener listener) {
        menuButton.addActionListener(listener);
    }

    public void setBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
