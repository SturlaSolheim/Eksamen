package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileAccessSettings extends JPanel implements ActionListener {

    private JButton openButton;
    private JFileChooser chooser;

    public FileAccessSettings() {
        super();

        // Initialize the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        // Initialize and setup the button
        openButton = new JButton("Open File Chooser");
        openButton.addActionListener(this); // Set this class as the action listener for the button
        this.add(openButton); // Add the button to this JPanel
    }

    // Define the action to perform when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
            } else {
                System.out.println("No Selection ");
            }
        }
    }
}
