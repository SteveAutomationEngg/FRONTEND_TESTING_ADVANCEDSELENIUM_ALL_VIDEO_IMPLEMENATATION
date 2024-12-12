package practice.testng;

import org.testng.annotations.Test;

public class CreateContact1_PriorityTest {
	
	
	/* here we are using priority functionality of Testng where we set the priority
	 * if in case on first test case fail due to any reasoin synchronisation or defect in application
	 * all other test case  will execute normally
	 */
	
	
	/*[ as per rule of automation all the testcase should be independent that
	mean all testcase mai we will create first contact and then perform the other action]
	*/
	
	@Test (priority = 1)
	public void createContactTest() {
		System.out.println("Execute createContactTest --> HDFC");
		String s= null;
		if(s.equals("ram"))
		{System.out.println("dsdsdsds");
		
		}
	}
	
	@Test(priority = 2 )
	public void modifyContactTest() {
		System.out.println("execute Query insert contact in DB ==> ICICI");
		System.out.println("Execute modifyContactTest --> HDFC==> ICICI");
	}
	
	@Test(priority = 3)
	public void deleteContactTest() {
		System.out.println("execute query insert contact in DB ==> UPI");
		System.out.println("Execute deleteContactTest --> UPI");
	}

}
