package gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ListOfficesFrame extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public ListOfficesFrame() {
        setTitle("List of offices");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());

        // Define the column names for your table
        String[] columnNames = {"officeCode", "City", "addressLine1", "addressLine2", "state", "postalCode", "territory"};

        // Initialize the table model
        tableModel = new DefaultTableModel(columnNames, 0); // The '0' argument means the table starts off with zero rows

        // Initialize the table
        table = new JTable(tableModel);

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        this.add(scrollPane);

        setResizable(false);
        setVisible(true);
    }
}