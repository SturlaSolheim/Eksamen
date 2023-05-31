package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
import frames.TestDatabaseFrame;
import frames.AboutThisApp;
import frames.ExecuteSql;

public class PanelMenu extends JPanel implements ActionListener {

    private JButton button1, button2, button3, button4;

    public PanelMenu() {
        super();
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 240, 240));

        // Initialize the buttons
        button1 = createButton("Test database connection");
        button2 = createButton("Execute SQL query");
        button3 = createButton("Exit application");
        button4 = createButton("About the app");

        // Make this class the action listener for the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        // Add the buttons to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;  // Center both horizontally and vertically
        c.insets = new Insets(1, 10, 10, 10);

        // Position the first button at (0,0)
        c.gridx = 0;
        c.gridy = 0;
        add(button1, c);

        // Position the second button at (0,1)
        c.gridy = 1;
        add(button2, c);

        // Position the third button at (0,2)
        c.gridy = 2;
        add(button3, c);

        // Position the fourth button at (0,3)
        c.gridy = 3;
        add(button4, c);
    }

    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Handle button clicks here
    	        // For example:
    	    	
    	    	if (e.getSource() == button1) {
    	    	    new TestDatabaseFrame();
    	    	}
   	        
    	        if (e.getSource() == button3) {
    	            System.out.println("Exit button clicked");
    	            System.exit(0);
    	     
    	        }
    	        
    	        if (e.getSource() == button2) {
    	        	
    	            ExecuteSql executeSql = new ExecuteSql();
    	            executeSql.setVisible(true);
    	        }
    	        
    	        if (e.getSource() == button4) {
    	            
    	            AboutThisApp aboutThisApp = new AboutThisApp();
    	            aboutThisApp.showMessage();
    	        }
    	    }
    	
    

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Calibri", Font.PLAIN, 24));
        button.setPreferredSize(new Dimension(250, 50));
        return button;
    }
} 
    
    
    
    
    









