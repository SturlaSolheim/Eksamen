package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import database.DatabaseHelper;
import gui.ListOfficesFrame;

public class PanelMenu extends JPanel implements ActionListener {

    private JButton button1, button2, button3, button4;

    public PanelMenu() {
        super();
        setLayout(new GridBagLayout());

        // Initialize the buttons
        button1 = new JButton("Test database connection");
        button2 = new JButton("Execute SQL query");
        button3 = new JButton("Button 3");
        button4 = new JButton("About the app");

        // Make this class the action listener for the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

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
        c.gridx = 0;
        c.gridy = 2;
        this.add(button3, c);

        // Add an invisible component that takes up all the extra space
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 3;
        this.add(new JPanel(), c); // Adding a new empty JPanel

        // Position the fourth button at (0,4) - at the bottom of the panel
        c.weighty = 0.0; // Reset to default
        c.gridx = 0;
        c.gridy = 4;
        this.add(button4, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks here
        // For example:
        if (e.getSource() == button1) {
			try {
				DatabaseHelper db = new DatabaseHelper();
				db.open();
				db.test();
				db.close();
				String message = "Connection succesful";
				JOptionPane.showMessageDialog(this, message);
			} catch (Exception e2) {
				String message = "Connection not succesful";
				JOptionPane.showMessageDialog(this, message);
			}	
        }
        
        if(e.getSource() == button3) {
        	try {
				ListOfficesFrame frame = new ListOfficesFrame();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        // And so on for button2, button3, and button4
    }
}
