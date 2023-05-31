package frames;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.DatabaseHelper;
import gui.PanelMenu;


public class TestDatabaseFrame extends JFrame {

    public TestDatabaseFrame() {
        super("Test Database Connection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();

        try {
            DatabaseHelper db = new DatabaseHelper();
            db.open();
            db.test();
            db.close();
            label.setText("Connection successful");
        } catch (Exception ex) {
            label.setText("Connection not successful");
        }

        panel.add(label);
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}