package practice.testng;

import org.testng.annotations.Test;

public class CreateContact3_InvocationCountTest {
	
	/* 
	 * here we have use the invocationCount fuctionality of Testng
	 * and why we don't use for LOOP 
	 * it will also iterate the testScript but if  any iteration fail that complete testscript get failed
	 * JVM will count For loop test case only one test case wherecase invoaction count jvm will count the no. of times 
	 * test  script execute
	 */
	  // [ EXECUTE AND WATCH CONSOLE FOR MORE INFO]
	
	@Test(invocationCount = 10)
	public void createContactTest() {
		System.out.println("Execute createContactTest --> HDFC");
		
	}
	
     
	@Test
	public void modifyContactTest() {
		for(int i=1; i<=10 ; i++) {
		System.out.println("Execute modifyContactTest --> HDFC==> ICICI");
		}
	}
}
