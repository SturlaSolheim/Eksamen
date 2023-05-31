//This class is written by sturla. This is the form to register or modify an employee.

package frames;

import java.awt.*;
import javax.swing.*;

public class AddOrModifyEmployeeFrame extends JFrame {
    JTextField employeeNumberField, lastNameField, firstNameField, extensionField, officeCodeField, reportsToField, jobTitleField;
    JLabel employeeNumberLabel, lastNameLabel, firstNameLabel, extensionLabel, officeCodeLabel, reportsToLabel, jobTitleLabel;

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

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
