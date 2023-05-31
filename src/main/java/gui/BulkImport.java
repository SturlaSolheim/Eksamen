package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DatabaseHelper;

public class BulkImport extends JFrame implements ActionListener {
	  JButton order;
	  JLabel ordername;
	    JButton submitButton;

	public BulkImport() {
		 super("import of orders");
		   
		 setSize(1000, 500);
			setLocationRelativeTo(null);
	        setLayout(new GridBagLayout());

	        GridBagConstraints c = new GridBagConstraints();
	        c.gridx = 1000;
	        c.gridy = 1000;
	        c.fill = GridBagConstraints.HORIZONTAL;
	       


	        ordername = new JLabel("import order");
	        c.gridx = 0;
	        c.gridy = 0;
	        //add(employeeNumberLabel, c);
	        order = new JButton("choose a file");
	        c.gridx = 1;
	        add(order, c);

	      
	        submitButton = new JButton("Submit");
	        c.gridx = 0;
	        c.gridy++;
	        c.gridwidth = 200;
	        add(submitButton, c);
	        submitButton.addActionListener(this);

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	}
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(e.getSource() == submitButton) {
	                submitToDatabase();
	            }
	        }
	        
	        private void submitToDatabase() {
	        	DatabaseHelper db = new DatabaseHelper();
	        	setVisible(false); 
				dispose();
	    }
		
	}

