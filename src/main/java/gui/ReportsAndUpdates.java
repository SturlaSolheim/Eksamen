package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReportsAndUpdates {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reports and Updates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JButton addModifyEmployeeButton = new JButton("Add or Modify Employee");
        JButton listAllProductsButton = new JButton("List All Products");
        JButton listAllOfficesButton = new JButton("List All Offices");
        JButton bulkImportOrdersButton = new JButton("Bulk Import of Orders");
        
        panel.add(addModifyEmployeeButton);
        panel.add(listAllProductsButton);
        panel.add(listAllOfficesButton);
        panel.add(bulkImportOrdersButton);
        
        frame.getContentPane().add(panel);
       
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
