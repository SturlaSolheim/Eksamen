
package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DatabaseHelper;

public class ExecuteSql extends JFrame {

    private JTextArea sqlTextArea;
    private JButton executeButton;
    private JTextArea resultTextArea;

    public ExecuteSql() {
    	super();
        setTitle("Execute SQL");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        sqlTextArea = new JTextArea(5, 30);
        JScrollPane sqlScrollPane = new JScrollPane(sqlTextArea);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(sqlScrollPane, c);

        executeButton = new JButton("Execute");
        executeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeSqlQuery();
            }
        });
        c.gridy = 1;
        panel.add(executeButton, c);

        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        c.gridy = 2;
        panel.add(resultScrollPane, c);

        add(panel);
    }

    private void executeSqlQuery() {
        String sql = sqlTextArea.getText();
        try {
            DatabaseHelper db = new DatabaseHelper();
            db.open();
            ResultSet resultSet = db.selectSql(sql);
            displayResultSet(resultSet);
            db.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error executing SQL query: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayResultSet(ResultSet resultSet) throws SQLException {
        StringBuilder sb = new StringBuilder();
        while (resultSet.next()) {
            String rowData = "";
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                rowData += resultSet.getString(i) + "\t";
            }
            sb.append(rowData).append("\n");
        }
        resultTextArea.setText(sb.toString());
    }

	public void showMessage() {
		// TODO Auto-generated method stub
		
	}
}