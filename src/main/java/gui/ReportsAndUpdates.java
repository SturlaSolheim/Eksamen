package gui;




	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class ReportsAndUpdates extends JPanel implements ActionListener {
		
		String comment = "Select commands";
		

	    public ReportsAndUpdates() {
	    	
	   
	        super();
	        
	        System.out.println(comment);
	        
	        setLayout(new GridBagLayout());


	  
	        
	        
	        
	        JButton addModifyEmployeeButton = new JButton("Add or Modify Employee");
	        JButton listAllProductsButton = new JButton("List All Products");
	        JButton listAllOfficesButton = new JButton("List All Offices");
	        JButton bulkImportOrdersButton = new JButton("Bulk Import of Orders");

	        GridBagConstraints buttonConstraints = new GridBagConstraints();
	        buttonConstraints.gridx = 0;
	        buttonConstraints.gridy = 0; // Set the grid y position to 1 (bottom row)
	        buttonConstraints.gridwidth = 1; // Set the grid width to 1
	        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
	        buttonConstraints.weightx = 1.0; // Set the horizontal weight to expand the buttons
	        buttonConstraints.insets = new Insets(1, 1, 1, 1); // Add spacing around the buttons

	     
	       
	        buttonConstraints.gridx = 0;
	        this.add(addModifyEmployeeButton, buttonConstraints);
	       
	        buttonConstraints.gridx = 1;
	        this.add(listAllProductsButton, buttonConstraints);

	        buttonConstraints.gridx = 2;
	        this.add(listAllOfficesButton, buttonConstraints);

	        buttonConstraints.gridx = 3;
	        this.add(bulkImportOrdersButton, buttonConstraints);

	        addModifyEmployeeButton.addActionListener(this);
	        listAllProductsButton.addActionListener(this);
	        listAllOfficesButton.addActionListener(this);
	        bulkImportOrdersButton.addActionListener(this);

	       
	    }

	    // Define the action to perform when a button is clicked
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand().equals("Add or Modify Employee")) {
	            System.out.println("Add or Modify Employee button clicked");
	            // Perform action for add/modify employee button
	        } else if (e.getActionCommand().equals("List All Products")) {
	            System.out.println("List All Products button clicked");
	            // Perform action for list all products button
	        } else if (e.getActionCommand().equals("List All Offices")) {
	            System.out.println("List All Offices button clicked");
	        	ListOfficesFrame frame = new ListOfficesFrame();
	            // Perform action for list all offices button
	        } else if (e.getActionCommand().equals("Bulk Import of Orders")) {
	            System.out.println("Bulk Import of Orders button clicked");
	            // Perform action for bulk import orders button
	        }
	    }

	    
	}
