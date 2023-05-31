package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DatabaseHelper;

public class listOfCustomers extends JPanel {

    private JLabel selectionLabel;
    private JRadioButton cityRadioButton;
    private JRadioButton stateRadioButton;
    private JComboBox<String> selectionComboBox;
    private JButton writeListButton;

    public listOfCustomers() {
        super();
        setLayout(new GridBagLayout());

        selectionLabel = new JLabel("Select: ");
        cityRadioButton = new JRadioButton("City");
        stateRadioButton = new JRadioButton("State");
        selectionComboBox = new JComboBox<>();
        writeListButton = new JButton("Write customer list");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cityRadioButton);
        buttonGroup.add(stateRadioButton);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(cityRadioButton);
        radioPanel.add(stateRadioButton);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        contentPanel.add(selectionLabel, gbc);

        gbc.gridx = 1;
        contentPanel.add(selectionComboBox, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        contentPanel.add(writeListButton, gbc);

        setLayout(new BorderLayout());
        add(radioPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        cityRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    List<String> cities = getCitiesFromDatabase();
                    updateSelectionComboBox(cities);
                }
            }
        });

        stateRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    List<String> states = getStatesFromDatabase();
                    updateSelectionComboBox(states);
                }
            }
        });

        writeListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    writeCustomerList();
                    JOptionPane.showMessageDialog(listOfCustomers.this, "Customer list has been written to file successfully.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    private List<String> getCitiesFromDatabase() {
        List<String> cities = new ArrayList<>();

        DatabaseHelper db = new DatabaseHelper();
        ResultSet resultSet;
        try {
            db.open();
            resultSet = db.selectSql("SELECT DISTINCT city FROM customers");

            while (resultSet.next()) {
                String city = resultSet.getString("city");
                cities.add(city);
            }

            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    private List<String> getStatesFromDatabase() {
        List<String> states = new ArrayList<>();

        DatabaseHelper db = new DatabaseHelper();
        ResultSet resultSet;
        try {
            db.open();
            resultSet = db.selectSql("SELECT DISTINCT state FROM customers");

            while (resultSet.next()) {
                String state = resultSet.getString("state");
                states.add(state);
            }

            return states;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return states;
    }

    private void updateSelectionComboBox(List<String> items) {
        selectionComboBox.removeAllItems();
        for (String item : items) {
            selectionComboBox.addItem(item);
        }
    }

    private void writeCustomerList() throws SQLException {
        String selectedItem = (String) selectionComboBox.getSelectedItem();
        if (selectedItem == null) {
            JOptionPane.showMessageDialog(this, "Please select a city or state.");
            return;
        }

        String query;
        String fieldName;
        if (cityRadioButton.isSelected()) {
            query = "SELECT * FROM customers WHERE city = ?";
            fieldName = "city";
        } else {
            query = "SELECT * FROM customers WHERE state = ?";
            fieldName = "state";
        }

        DatabaseHelper db = new DatabaseHelper();
        try {
           
            db.open();
            ResultSet resultSet = db.selectSql("SELECT * FROM customers");
           

            StringBuilder customerList = new StringBuilder();
            while (resultSet.next()) {
                String customer = resultSet.getString("customerName");
                customerList.append(customer).append("\n");
            }

            if (customerList.length() == 0) {
                JOptionPane.showMessageDialog(this, "No customers found in the selected " + fieldName + ".");
                return;
            }

        
            String filename = "customer_list.txt";
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(customerList.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred while writing the customer list.");
                e.printStackTrace();
                return;
            }

         
            JTextArea textArea = new JTextArea(10, 40);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JFrame frame = new JFrame("Customer List - " + selectedItem);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

          
            try {
                java.nio.file.Path filePath = java.nio.file.Paths.get(filename);
                java.util.List<String> lines = java.nio.file.Files.readAllLines(filePath);
                for (String line : lines) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while reading the customer list.");
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while querying the database.");
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("List of Customers");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new listOfCustomers());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
