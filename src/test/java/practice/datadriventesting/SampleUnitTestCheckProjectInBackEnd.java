package practice.datadriventesting;

import static org.testng.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	
	@Test
	public void projectCheckTest() throws SQLException {
		
		String expectedDesignation="HR Assistant";
		boolean flag = false;
		
		// step1:load/Register the database driver

				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				// step2: Connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
				System.out.println("===========DONE=====================");

				// step3:Create sql Statement
				Statement stat = conn.createStatement();

				// Step4:Execute select query & get result
				ResultSet resultset = stat.executeQuery("select * from employee;");
				
				
				while(resultset.next()) {
					String actDesignation=resultset.getString(3);
					
					if (expectedDesignation.equals(actDesignation)) {
						flag = true;
						System.out.println(expectedDesignation+"is available == PASS");
					}
					
				}
				
				if (flag == false) {
					
					System.out.println(expectedDesignation+"is not available == FAIL");
					//Assert.fail();   if u real want fail the test script then we use this
				}
			
				//step5: close the connection
				  conn.close();

	}

}
