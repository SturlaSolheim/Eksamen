package gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class listOfCustomers extends JFrame {

    private JLabel selectionLabel;
    private JRadioButton cityRadioButton;
    private JRadioButton stateRadioButton;
    private JComboBox<String> selectionComboBox;

    public listOfCustomers() {
        setTitle("City/State Selection");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        selectionLabel = new JLabel("Select: ");
        cityRadioButton = new JRadioButton("City");
        stateRadioButton = new JRadioButton("State");
        selectionComboBox = new JComboBox<>();

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

        setVisible(true);
    }

    private List<String> getCitiesFromDatabase() {
        List<String> cities = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "student", "student")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT city FROM customers");
            while (resultSet.next()) {
                String city = resultSet.getString("city");
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private List<String> getStatesFromDatabase() {
        List<String> states = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "student", "student")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT state FROM customers");
            while (resultSet.next()) {
                String state = resultSet.getString("state");
                states.add(state);
            }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                new listOfCustomers();
            }
        });
    }
}

