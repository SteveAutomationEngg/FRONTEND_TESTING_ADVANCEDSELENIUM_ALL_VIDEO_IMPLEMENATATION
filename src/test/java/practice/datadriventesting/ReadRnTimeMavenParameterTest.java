package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRnTimeMavenParameterTest {
	
		
		@Test
		public void runTimeParameterTest() {
		
			String URL = System.getProperty("url");
			String BROWSER = System.getProperty("browser");
			String USERNAME = System.getProperty("username");
			String PASSWORD = System.getProperty("password");
			
		System.out.println("Env Data ===> URL ===>" + URL);
		System.out.println("Browser Data ===>  ===>" + BROWSER);
		System.out.println("Username Data ===>  ===>" + USERNAME);
		System.out.println("Password  Data ===>  ===>" + PASSWORD);
	}
		/*here we are passing the url,browser,username and password at the run time 
		 * using cmd line by help of  mvn parameters. 
		 */

}

