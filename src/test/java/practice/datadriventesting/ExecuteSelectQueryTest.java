package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		Connection conn= null;
		try {
			
			// step1:load/Register the database driver

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		// step2: Connect to database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		System.out.println("===========DONE=====================");

		// step3:Create sql Statement
		Statement stat = conn.createStatement();

		// Step4:Execute select query & get result
		ResultSet resultset = stat.executeQuery("select * from employee;");

		while (resultset.next()) {

			System.out.println(resultset.getInt(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3)
					+ "\t" + resultset.getInt(4) + "\t" + resultset.getInt(5));

		}
		}
		
		catch(Exception e)
		{
			System.out.println("handle Exception");
		}
		
		finally {
			
		//Step5: Close the connection
		conn.close();
		System.out.println("=======Conection Closed===========");
		}
		
		/*
		 * resultset.next(); System.out.println(resultset.getInt(1));
		 * System.out.println(resultset.getString(2));
		 * System.out.println(resultset.getString(3));
		 * System.out.println(resultset.getInt(4));
		 * System.out.println(resultset.getInt(5));
		 */

	}

}
