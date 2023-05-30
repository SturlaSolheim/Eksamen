package gui;


/*
 * Main application window
 * 
 * */


import java.awt.GridLayout;

import javax.swing.JFrame;



public class MainWindow extends JFrame {
	
	private ApplicationMenu appMenu = new ApplicationMenu();
	private MainContent content = new MainContent();
	private ListOfCustomers listOfCustomer = new ListOfCustomers();
	

	public MainWindow() {
		
		setTitle("Example application");
		setSize(1030, 1000);
		setLocationRelativeTo(null);
		setLayout(new GridLayout());
		
		// add main menu
		setJMenuBar(appMenu);

		// add content
		add(content);
		add(listOfCustomer);

		setResizable(false);
		setVisible(true);
	}


}
