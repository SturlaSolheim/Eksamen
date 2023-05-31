package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseHelper;
import frames.ListOfficesFrame;

public class PanelMenu extends JPanel implements ActionListener {

    private JButton button1, button2, button3, button4;

    public PanelMenu() {
        super();
        setLayout(new GridBagLayout());

        // Initialize the buttons
        button1 = new JButton("Test database connection");
        button2 = new JButton("Execute SQL query");
        button3 = new JButton("Exit application");
        button4 = new JButton("About the app");

        // Make this class the action listener for the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        Font boldFontExit = new Font(button3.getFont().getName(), Font.BOLD, button3.getFont().getSize());
        button3.setFont(boldFontExit);
        
        Font boldFontAbout = new Font(button3.getFont().getName(), Font.BOLD, button3.getFont().getSize());
        button4.setFont(boldFontAbout);
        
        // Add the buttons to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Position the first button at (0,0)
        c.gridx = 0;
        c.gridy = 0;
        this.add(button1, c);

        // Position the second button at (0,1)
        c.gridx = 0;
        c.gridy = 1;
        this.add(button2, c);

        // Position the third button at (0,2)
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 4;
        this.add(button3, c);

        // Add an invisible component that takes up all the extra space
        c.weighty = 10;
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JPanel(), c); // Adding a new empty JPanel

        // Position the fourth button at (0,4) - at the bottom of the panel
        c.weighty = 0; // Reset to default
        c.gridx = 0;
        c.gridy = 2;
        this.add(button4, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks here
        // For example:
        if (e.getSource() == button1) {
            try {
                // Test database connection
                DatabaseHelper db = new DatabaseHelper();
                db.open();
                db.test();
                db.close();
                String message = "Connection successful";
                JOptionPane.showMessageDialog(this, message);
            } catch (Exception e2) {
                String message = "Connection not successful";
                JOptionPane.showMessageDialog(this, message);
            }
            
            
        } else if (e.getSource() == button2) {
            // Execute SQL query
            String query = JOptionPane.showInputDialog(this, "Enter SQL query:");
            if (query != null && !query.trim().isEmpty()) {
                executeQuery(query);
            }
            
            
        } else if (e.getSource() == button3) {
            System.out.println("Exit button clicked");
            System.exit(0);
        }
    }

    private void executeQuery(String query) {
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String username = "student";
        String password = "student";
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process and display the result set as needed
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error executing query: " + ex.getMessage());
        }
    }

    
}








