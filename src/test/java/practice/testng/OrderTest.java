package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {

	
	//here BillingAnOrderTest Testcase in depend on CreateOrderTest 
	//if due some issue my first T.C failed its dependend T.C will be Skipped. [No Execution]
	
	@Test
	public void createOrderTest() {
		System.out.println("Execute createOrderTest ==> 123");
		
		String str= null;
		System.out.println(str.equals("123"));
	}

	@Test(dependsOnMethods = "createOrderTest")
	public void billingAnOrderTest() {
		System.out.println("Execute billingAnOrderTest ==> 123");
	}
	
}
