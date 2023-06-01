/**
 * [Brief description of the class]
 * 
 * [Detailed description of the class]
 * 
 * [Author(s) and their contribution]
 * 
 * [Purpose of the class]
 * 
 * [Explanation of the included methods]
 */

package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileAccessSettings extends JPanel implements ActionListener {

    private JButton openButton;
    private JFileChooser chooser;
    private JLabel chosenFolder;

    public FileAccessSettings() {
        super();
        setLayout(new GridBagLayout());

        // Initialize the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        // Initialize and setup the button
        openButton = new JButton("Change folder");
        openButton.setToolTipText("Click to change the folder");
        openButton.addActionListener(this); // Set this class as the action listener for the button

        // Initialize the label
        chosenFolder = new JLabel("No file chosen");

        // GridBagLayout constraints for the button
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;

        // GridBagLayout constraints for the label
        
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 1;
        labelConstraints.gridy = 0;
        labelConstraints.fill = GridBagConstraints.HORIZONTAL;
        labelConstraints.anchor = GridBagConstraints.EAST; 
        labelConstraints.insets = new Insets(0, 5, 5, 5);
        
        
        // Add the components to this JPanel
        this.add(openButton, buttonConstraints);
        this.add(chosenFolder, labelConstraints);
    }

    // Define the action to perform when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                chosenFolder.setText("Chosen file: " + chooser.getSelectedFile().toString());
            } else {
                System.out.println("No Selection ");
            }
        }
    }
}
