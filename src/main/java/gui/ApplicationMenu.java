package gui;

/*
 * Creates main menu of the application
 * */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import database.DatabaseHelper;


public class ApplicationMenu extends JMenuBar implements ActionListener {
	
	private JMenu menu_file = null;
	private JMenuItem dBconnectionItem = null;
	private JMenuItem selectFileItem = null;
	private JMenuItem writeCustomersItem = null;
	private JMenuItem bulkImportItem = null;
	private JMenuItem exitItem = null;
	
	private JMenu menu_help = null;
	private JMenuItem option_tip = null;
	
	private Font bigFont = new Font("Calibri", Font.PLAIN, 28);
	private Font smallFont = new Font("Calibri", Font.PLAIN, 24);
	
	protected ApplicationMenu() {
		displayMenuBar();
	}
	
	/**
     * Display of the menu bar:
     * 		Menu
     *			Test database connection
     * 			Exit
     *`		Help
     *			About the application
     */
	
	protected void displayMenuBar() {
		UIManager.put("Menu.font", bigFont);
		UIManager.put("MenuItem.font", smallFont);
		
		//Defines file menu
		menu_file = new JMenu("File");
		
		dBconnectionItem = new JMenuItem("Test database connection");
		dBconnectionItem.addActionListener(this);
		
		selectFileItem = new JMenuItem("Select file");
		selectFileItem.addActionListener(this);
		
		writeCustomersItem = new JMenuItem("Write customers into file");
		writeCustomersItem.addActionListener(this);
		
		bulkImportItem = new JMenuItem("Bulk import of orders");
		bulkImportItem.addActionListener(this);
		
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);

		//Adds items to file menu
		menu_file.add(selectFileItem);
		menu_file.add(writeCustomersItem);
		menu_file.add(bulkImportItem);
		menu_file.add(dBconnectionItem);
		menu_file.add(exitItem);

		menu_help = new JMenu("Help");
		
		option_tip = new JMenuItem("About the application");
		option_tip.addActionListener(this);
		menu_help.add(option_tip);

		this.add(menu_file);
		this.add(menu_help);
	}
	
	
	// Actions that are performed upon the clicks on the main menu by the user
	public void actionPerformed(ActionEvent event) {
		String arg = event.getActionCommand();
		if (arg.equals("Test database connection")) {
			try {
				DatabaseHelper db = new DatabaseHelper();
				db.open();
				db.test();
				db.close();
				displayMessage("Connection tested succesfully!");
			} catch (Exception e) {
				displayMessage("Error with the connection!");
			}	
		}else if (arg.equals("Exit")) {
			System.exit(0);		
		}else if (arg.equals("About the application")) {
			JTextArea helptext = new JTextArea("This is the small application example\n\n- it provides the display of basic functionality\n- You are allowed to use its structure\n- and upgrade it for a higher grade");
			helptext.setEditable(false);
			helptext.setOpaque(false);
			helptext.setFont(bigFont);
			JOptionPane.showMessageDialog(this, helptext, "About the application", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// simple method that display option pane with the provided message
	private void displayMessage(String message) {
		UIManager.put("OptionPane.messageFont", bigFont);
		UIManager.put("OptionPane.buttonFont", bigFont);
		JOptionPane.showMessageDialog(this, message);
	}
	
	
}









