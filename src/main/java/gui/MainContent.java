package gui;

import java.awt.Font;
import database.DatabaseHelper;

import javax.swing.JPanel;


public class MainContent extends JPanel {
	
	private Font bigFont = new Font("Calibri", Font.PLAIN, 40);
	private Font smallFont = new Font("Calibri", Font.PLAIN, 24);
	private DatabaseHelper dbHelper = new DatabaseHelper();
	
	public MainContent() {
		super();
		setLayout(null);
		
	}

}
