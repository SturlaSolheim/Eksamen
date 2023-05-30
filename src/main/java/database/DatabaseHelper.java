package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
	
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		
		try {
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "student" , "student");
			
			System.out.println("Database connection successful!\n");
			
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select * from employees");
			
			while  (myRs.next()) {
				System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
		    }
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			
			}
		}
	}
}
