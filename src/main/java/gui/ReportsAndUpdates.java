/**
 * [Brief description of the class]
 * 
 * [Detailed description of the class]
 * 
 * [Author(s) and their contribution]
 * 
 * [Purpose of the class]
 * 
 * [Explanation of the included methods]
 */

package gui;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

import frames.AddEmployeeFrame;
import frames.ListAllProducts;
import frames.ListOfficesFrame;
import frames.ModifyEmployeeFrame;

import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
        import java.sql.SQLException;

	public class ReportsAndUpdates extends JPanel implements ActionListener {
	
		
	    public ReportsAndUpdates() {
	    	
	        super(); 
	   
	        setLayout(new GridBagLayout());
                
	        JButton addModifyEmployeeButton = new JButton("Add Employee");
	        addModifyEmployeeButton.setToolTipText("Click to add a new employee");

	        JButton modifyEmployeeButton = new JButton("Modify Employee");
	        modifyEmployeeButton.setToolTipText("Click to modify an existing employee");

	        JButton listAllProductsButton = new JButton("List All Products");
	        listAllProductsButton.setToolTipText("Click to list all products");

	        JButton listAllOfficesButton = new JButton("List All Offices");
	        listAllOfficesButton.setToolTipText("Click to list all offices");

	        JButton bulkImportOrdersButton = new JButton("Bulk Import of Orders");
	        bulkImportOrdersButton.setToolTipText("Click to perform a bulk import of orders");

	        
	        JLabel selectCommandLabel = new JLabel("Select command:");
	        GridBagConstraints labelConstraints = new GridBagConstraints();
	        
	        GridBagConstraints buttonConstraints = new GridBagConstraints();
	        buttonConstraints.gridx = 2;
	        buttonConstraints.gridy = 2; 
	        buttonConstraints.gridwidth = 1; 
	        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
	        buttonConstraints.weightx = 1; 
	        buttonConstraints.insets = new Insets(1, 1, 1, 1); 
	        this.add(selectCommandLabel, labelConstraints);
	        
	        
	        
	        
	        buttonConstraints.gridx = 0;
	        this.add(addModifyEmployeeButton, buttonConstraints);
	        
	        buttonConstraints.gridx = 1;
	        this.add(modifyEmployeeButton, buttonConstraints);
	        
	        buttonConstraints.gridx = 2;
	        this.add(listAllProductsButton, buttonConstraints);

	        buttonConstraints.gridx = 3;
	        this.add(listAllOfficesButton, buttonConstraints);

	        buttonConstraints.gridx = 4;
	        this.add(bulkImportOrdersButton, buttonConstraints);

	        addModifyEmployeeButton.addActionListener(this);
	        modifyEmployeeButton.addActionListener(this); 
	        listAllProductsButton.addActionListener(this);
	        listAllOfficesButton.addActionListener(this);
	        bulkImportOrdersButton.addActionListener(this);       
	    }

	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand().equals("Add Employee")) {
	           AddEmployeeFrame frame = new AddEmployeeFrame();
	        } else if (e.getActionCommand().equals("List All Products")) {
                   try {
			ListAllProducts frame = new ListAllProducts();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                   }
	            
	        } else if (e.getActionCommand().equals("List All Offices")) {
	        	try {
					ListOfficesFrame frame = new ListOfficesFrame();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
	           
	        } else if (e.getActionCommand().equals("Bulk Import of Orders")) {
	        	
	        	 OrderImportGUI orderImportFrame = new OrderImportGUI();
		           
	        }
	        else if (e.getActionCommand().equals("Modify Employee")) {
	            ModifyEmployeeFrame frame = new ModifyEmployeeFrame();
	        }
	        
	    }	    
}
