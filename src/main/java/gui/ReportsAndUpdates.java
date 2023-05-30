package gui;




	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.SwingUtilities;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class ReportsAndUpdates extends JPanel implements ActionListener {
		

	    public ReportsAndUpdates() {
	        super();
	        setLayout(new GridBagLayout());

	

	        JButton addModifyEmployeeButton = new JButton("Add or Modify Employee");
	        JButton listAllProductsButton = new JButton("List All Products");
	        JButton listAllOfficesButton = new JButton("List All Offices");
	        JButton bulkImportOrdersButton = new JButton("Bulk Import of Orders");

	        GridBagConstraints buttonConstraints = new GridBagConstraints();
	        buttonConstraints.gridx = 0;
	        buttonConstraints.gridy = 0;
	        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
	        buttonConstraints.ipadx = 10;
	        buttonConstraints.ipady = 10;
	       

	        this.add(addModifyEmployeeButton, buttonConstraints);

	        buttonConstraints.gridy = 1;
	        this.add(listAllProductsButton, buttonConstraints);

	        buttonConstraints.gridy = 2;
	        this.add(listAllOfficesButton, buttonConstraints);

	        buttonConstraints.gridy = 3;
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
	            // Perform action for list all offices button
	        } else if (e.getActionCommand().equals("Bulk Import of Orders")) {
	            System.out.println("Bulk Import of Orders button clicked");
	            // Perform action for bulk import orders button
	        }
	    }

	    
	}
