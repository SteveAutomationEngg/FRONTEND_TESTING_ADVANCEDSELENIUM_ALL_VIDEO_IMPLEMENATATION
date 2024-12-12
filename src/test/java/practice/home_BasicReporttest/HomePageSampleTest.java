 package practice.home_BasicReporttest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

	//inplace of system.out.println we have use Reporter class of testng to get
	//low report ( by using Reporter.log("step-1", true) ==> now values will be inserted in html report as well as Console
	
	@Test
	public void homePageTest(Method mtd) {
		
	Reporter.log(mtd.getName() +"\t" + "Test Start");
	
	Reporter.log("step-1");

	Reporter.log("step-2");
	Reporter.log("step-3");
	Assert.assertEquals("Home-CRM","Home-CRM");
	Reporter.log("step-4");
	
	Reporter.log(mtd.getName() +"\t" + "Test End");
	}
	
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		
	Reporter.log(mtd.getName() + "\t" + "Test Start");
	
	SoftAssert assertObj = new SoftAssert();	
	Reporter.log("step-1");
	assertObj.assertFalse(true);
	Reporter.log("step-2");
	Assert.assertTrue(true);
	Reporter.log("step-3");
	Reporter.log("step-4");
	

	Reporter.log(mtd.getName() +"\t" + "Test End");
	assertObj.assertAll();
	}
}



