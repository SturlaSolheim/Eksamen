//This class is written by sturla. This is the form to register or modify an employee.

package frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import database.DatabaseHelper;

public class AddOrModifyEmployeeFrame extends JFrame implements ActionListener {
    JTextField employeeNumberField, lastNameField, firstNameField, extensionField, officeCodeField, reportsToField, jobTitleField, emailField;
    JLabel employeeNumberLabel, lastNameLabel, firstNameLabel, extensionLabel, officeCodeLabel, reportsToLabel, jobTitleLabel, emailLabel;
    JButton submitButton;
    
    public AddOrModifyEmployeeFrame() {
        super("Add or Modify Employee");
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);

        employeeNumberLabel = new JLabel("Employee Number");
        c.gridx = 0;
        c.gridy = 0;
        add(employeeNumberLabel, c);
        employeeNumberField = new JTextField(20);
        c.gridx = 1;
        add(employeeNumberField, c);

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
        officeCodeField = new JTextField(20);
        c.gridx = 1;
        add(officeCodeField, c);

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
    
    
    public void printFieldValues() {
        String employeeNumber = employeeNumberField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String extension = extensionField.getText();
        String officeCode = officeCodeField.getText();
        String reportsTo = reportsToField.getText();
        String jobTitle = jobTitleField.getText();

        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Last Name: " + lastName);
        System.out.println("First Name: " + firstName);
        System.out.println("Extension: " + extension);
        System.out.println("Office Code: " + officeCode);
        System.out.println("Reports To: " + reportsTo);
        System.out.println("Job Title: " + jobTitle);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            printFieldValues();
        }
    }
    
    private void submitToDatabase() {
    	DatabaseHelper db = new DatabaseHelper();
    	try {
			db.open();
			db.insertEmployee(Integer.parseInt(employeeNumberField.getText()), lastNameField.getText(), firstNameField.getText(), extensionField.getText(), emailField.getText() ,Integer.parseInt(officeCodeField.getText()), Integer.parseInt(reportsToField.getText()), jobTitleField.getText());
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	

}
