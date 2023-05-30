package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper implements DatabaseInterface {
	
	// JDBC driver name and database URL
    private final String DB_URL = "jdbc:mysql://localhost/classicmodels";
    
    //  Database credentials
    private static final String USER = "student";
    private static final String PASS = "student";
    
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement prepStmt = null;
    private ResultSet rSet = null;
	

	
	@Override
    public void open() throws SQLException{
        try {
            //Establish connection
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            //Create statement that will be used for executing SQL queries
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();// More elegant solutions for catching errors exist but they are out of the scope for this course
        }
    }
    
    @Override
    public void close() throws SQLException{
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
    }
    
    @Override
    public void test() throws SQLException{
        try {
            String sql;
            sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql); // DML
            // stmt.executeUpdate(sql); // DDL
            
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Display values
            	System.out.println(rs.getString("lastName") + ", " + rs.getString("firstName"));
            }
            //STEP 6: Clean-up environment
            rs.close();
        } catch (SQLException ex) {
        	ex.printStackTrace(); 
        }
    }
    
    public ResultSet selectSql(String sql) throws SQLException {
    	try {
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

    }
	
}
