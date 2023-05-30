package gui;


/*
 * Main application window
 * 
 * */


import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	


	public MainWindow() {
		
		setTitle("Example application");
		setSize(1030, 1000);
		setLocationRelativeTo(null);
		setLayout(new GridLayout());
		
		// add main menu


		// add content

		setResizable(false);
		setVisible(true);
	}


}
