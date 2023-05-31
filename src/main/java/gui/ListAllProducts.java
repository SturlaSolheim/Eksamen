
package gui;

import javax.swing.*;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DatabaseHelper;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sahir
 */
public class ListAllProducts extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    
    public ListAllProducts() throws SQLException {
        setTitle("List of Products");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());
        
        // Define the column names for your table
        String[] columnNames = {"Product Code",  "Product Name", "Product Line", "Product Scale", "Product Vendor", "Product Description", "Quantity In Stock", "Buy Price", "MSRP"};
        
        // Initialize the table model
        tableModel = new DefaultTableModel(columnNames, 0); // The '0' argument means the table starts off with zero rows
        
        // Initialize the table
        table = new JTable(tableModel);
        
        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        this.add(scrollPane);
        
        DatabaseHelper db = new DatabaseHelper();
        db.open();
        ResultSet resultset = db.selectSql("SELECT * FROM products");
        
        while (resultset.next()) {
        	String productCode = resultset.getString("productCode");
        	String productName = resultset.getString("productName");
        	String productLine = resultset.getString("productLine");
        	String productScale = resultset.getString("productScale");
        	String productVendor = resultset.getString("productVendor");
        	String productDescription = resultset.getString("productDescription");
        	int quantityInStock = resultset.getInt("quantityInStock");
        	String buyPrice = resultset.getString("buyPrice");
        	String MSRP = resultset.getString("MSRP");
	        
	        Object[] products = {productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP };
	        tableModel.addRow(products);
        }
        
        db.close();
        setResizable(true);
        setVisible(true);
    }   
}
