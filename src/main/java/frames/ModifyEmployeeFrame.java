//This class is written by Sturla. This is the form to  modify an employee.

package frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import database.DatabaseHelper;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ModifyEmployeeFrame extends JFrame implements ActionListener {
    JTextField employeeNumberField, lastNameField, firstNameField, extensionField, officeCodeField, reportsToField, jobTitleField, emailField;
    JLabel employeeNumberLabel, lastNameLabel, firstNameLabel, extensionLabel, officeCodeLabel, reportsToLabel, jobTitleLabel, emailLabel;
    JButton submitButton;
    JComboBox<Integer> officeCodeComboBox;
    JComboBox<Integer> employeeNumberComboBox;
    
    
    public ModifyEmployeeFrame() {
        super("Modify employee");
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);

        employeeNumberLabel = new JLabel("Employee Number");
        c.gridx = 0;
        c.gridy = 0;
        add(employeeNumberLabel, c);
        employeeNumberComboBox = new JComboBox<>();
        c.gridx = 1;
        add(employeeNumberComboBox, c);
        
        List<Integer> employeeNumberList = getEmployeeNumberFromDatabase();
        updateEmployeeNumberComboBox(employeeNumberList);
        
        employeeNumberComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	
                	DatabaseHelper db = new DatabaseHelper();
                	try {
						db.open();
						ResultSet resultSet = db.selectSql("SELECT * from customers where employeeNumer = " + (int)employeeNumberComboBox.getSelectedItem());
						
						while (resultSet.next()) {}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	
                	
                }
            }
        });
        

        lastNameLabel = new JLabel("Last Name");
        c.gridx = 0;
        c.gridy++;
        add(lastNameLabel, c);
        lastNameField = new JTextField(20);
        c.gridx = 1;
        add(lastNameField, c);

        firstNameLabel = new JLabel("First Name");
        c.gridx = 0;
        c.gridy++;
        add(firstNameLabel, c);
        firstNameField = new JTextField(20);
        c.gridx = 1;
        add(firstNameField, c);

        extensionLabel = new JLabel("Extension");
        c.gridx = 0;
        c.gridy++;
        add(extensionLabel, c);
        extensionField = new JTextField(20);
        c.gridx = 1;
        add(extensionField, c);
        
        emailLabel = new JLabel("Email");
        c.gridx = 0;
        c.gridy++;
        add(emailLabel, c);
        emailField = new JTextField(20);
        c.gridx = 1;
        add(emailField, c);

        officeCodeLabel = new JLabel("Office Code");
        c.gridx = 0;
        c.gridy++;
        add(officeCodeLabel, c);
        officeCodeComboBox = new JComboBox<>();
        c.gridx = 1;
        add(officeCodeComboBox, c);
        
        List<Integer> officeCodeList = getOfficeCodesFromDatabase();
        updateOfficeCodeComboBox(officeCodeList);

        reportsToLabel = new JLabel("Reports To");
        c.gridx = 0;
        c.gridy++;
        add(reportsToLabel, c);
        reportsToField = new JTextField(20);
        c.gridx = 1;
        add(reportsToField, c);

        jobTitleLabel = new JLabel("Job Title");
        c.gridx = 0;
        c.gridy++;
        add(jobTitleLabel, c);
        jobTitleField = new JTextField(20);
        c.gridx = 1;
        add(jobTitleField, c);
        
        submitButton = new JButton("Submit");
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 2;
        add(submitButton, c);
        submitButton.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            submitToDatabase();
        }
    }
    
    private void submitToDatabase() {
    	DatabaseHelper db = new DatabaseHelper();
    	try {
			db.open();
			db.insertEmployee(Integer.parseInt(employeeNumberField.getText()), lastNameField.getText(), firstNameField.getText(), extensionField.getText(), emailField.getText() ,(int)officeCodeComboBox.getSelectedItem(), Integer.parseInt(reportsToField.getText()), jobTitleField.getText());
			db.close();
			
            String message = "Employee registered";
            JOptionPane.showMessageDialog(this, message);
			
			setVisible(false); 
			dispose(); 
		} catch (SQLException e) {
            String message = "Employee not registered";
            JOptionPane.showMessageDialog(this, message);
			e.printStackTrace();
		}
    }
    
    private List<Integer> getOfficeCodesFromDatabase() {
        List<Integer> offices = new ArrayList<>();

        	DatabaseHelper db = new DatabaseHelper();

        	ResultSet resultSet;
			try {
	        	db.open();
				resultSet = db.selectSql("SELECT DISTINCT officeCode FROM offices");
				
	            while (resultSet.next()) {
	                int tmp = resultSet.getInt("officeCode");
	                offices.add(tmp);
	            }
	            
	            return offices;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}  	
        return offices;
    }
    
    private List<Integer> getEmployeeNumberFromDatabase() {
        List<Integer> employees = new ArrayList<>();

        	DatabaseHelper db = new DatabaseHelper();

        	ResultSet resultSet;
			try {
	        	db.open();
				resultSet = db.selectSql("SELECT DISTINCT employeeNumber FROM employees");
				
	            while (resultSet.next()) {
	                int tmp = resultSet.getInt("employeeNumber");
	                employees.add(tmp);
	            }
	            
	            return employees;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}  	
        return employees;
    }
    
    private void updateOfficeCodeComboBox(List<Integer> items) {
        officeCodeComboBox.removeAllItems();
        for (Integer item : items) {
            officeCodeComboBox.addItem(item);
        }
    }
    
    private void updateEmployeeNumberComboBox(List<Integer> items) {
        employeeNumberComboBox.removeAllItems();
        for (Integer item : items) {
            employeeNumberComboBox.addItem(item);
        }
    }
    	

}
