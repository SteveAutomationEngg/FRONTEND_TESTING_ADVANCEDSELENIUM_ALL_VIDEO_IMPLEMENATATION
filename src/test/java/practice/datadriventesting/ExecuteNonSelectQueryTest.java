package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		// step1:load/Register the database driver

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		// step2: Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		System.out.println("===========DONE=====================");

		// step3:Create sql Statement
		Statement stat = conn.createStatement();

		// Step4:Execute nonselect query & get result
		int result = stat.executeUpdate("insert into employee values('17','jogi baba','finance manager','64000','1');"); 
		System.out.println(result);

		//Step5: Close the connection
		conn.close();
		
		
		

	}

}
