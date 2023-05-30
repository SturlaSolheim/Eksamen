package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
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

        // Create an instance of PanelMenu
        PanelMenu panelMenu = new PanelMenu();

        // Specify the constraints for the PanelMenu
        c.fill = GridBagConstraints.VERTICAL; // This component should fill its display area vertically
        c.weightx = 0.2; // Specify the relative width of the PanelMenu
        c.weighty = 1.0; // Request any extra vertical space
        c.gridx = 0; // Place PanelMenu in the first column

        // Add the PanelMenu to the panel with the constraints
        this.add(panelMenu, c);

        // Create an instance of FileAccessSettings
        FileAccessSettings fileAccessSettings = new FileAccessSettings();
        fileAccessSettings.setBorder(BorderFactory.createTitledBorder("File Access Settings")); // Add a titled border

        // Specify the constraints for the FileAccessSettings
        c.fill = GridBagConstraints.BOTH; // This component should fill its display area
        c.weightx = 0.8; // Specify the relative width of the FileAccessSettings
        c.weighty = 1.0; // Request any extra vertical space
        c.gridx = 1; // Place FileAccessSettings in the second column

        // Add the FileAccessSettings to the panel with the constraints
        this.add(fileAccessSettings, c);
    }
}
