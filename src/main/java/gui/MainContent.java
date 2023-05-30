package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import database.DatabaseHelper;

public class MainContent extends JPanel {

    private Font bigFont = new Font("Calibri", Font.PLAIN, 40);
    private Font smallFont = new Font("Calibri", Font.PLAIN, 24);
    private DatabaseHelper dbHelper = new DatabaseHelper();

    public MainContent() {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // Create an instance of FileAccessSettings
        FileAccessSettings fileAccessSettings = new FileAccessSettings();

        // Specify the constraints for the component
        c.fill = GridBagConstraints.BOTH; // This component should fill its display area
        c.weightx = 1.0; // Request any extra horizontal space
        c.weighty = 1.0; // Request any extra vertical space

        // Add the FileAccessSettings to the panel with the constraints
        this.add(fileAccessSettings, c);
    }
}
