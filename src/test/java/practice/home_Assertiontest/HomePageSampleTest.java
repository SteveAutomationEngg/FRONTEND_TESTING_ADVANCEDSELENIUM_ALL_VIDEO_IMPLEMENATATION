package practice.home_Assertiontest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

	@Test
	public void homePageTest(Method mtd) {
		
	System.out.println(mtd.getName() +"\t" + "Test Start");
	SoftAssert assertObj = new SoftAssert();
	System.out.println("step-1");
	assertObj.assertTrue(false);
	System.out.println("step-2");
	Assert.assertEquals("Home", "Home");
	System.out.println("step-3");
	Assert.assertEquals("Home-CRM","Home-CRM");
	System.out.println("step-4");
	
	
	
	System.out.println(mtd.getName() +"\t" + "Test End");
	assertObj.assertAll();
	}
	
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		
	System.out.println(mtd.getName() + "\t" + "Test Start");
	
	SoftAssert assertObj = new SoftAssert();	
	System.out.println("step-1");
	assertObj.assertFalse(true);
	System.out.println("step-2");
	Assert.assertTrue(true);
	System.out.println("step-3");
	System.out.println("step-4");
	

	System.out.println(mtd.getName() +"\t" + "Test End");
	assertObj.assertAll();
	}
}



