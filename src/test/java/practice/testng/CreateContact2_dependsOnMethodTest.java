package practice.testng;

import org.testng.annotations.Test;

public class CreateContact2_dependsOnMethodTest {
	
	/* here  we are using depends on method functionality of testng if one test case fail 
	 * its depended testcases also failed
	 * and if execute any of the test case its dependent test case first execute
	 */
	
	
	@Test 
	public void createContactTest() {
		System.out.println("Execute createContactTest --> HDFC");
		String s= null;
		if(s.equals("ram"))
		{System.out.println("dsdsdsds");
		
		}
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("execute Query insert contact in DB ==> ICICI");
		System.out.println("Execute modifyContactTest --> HDFC==> ICICI");
		
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("execute query insert contact in DB ==> UPI");
		System.out.println("Execute deleteContactTest --> UPI");
	}

}
