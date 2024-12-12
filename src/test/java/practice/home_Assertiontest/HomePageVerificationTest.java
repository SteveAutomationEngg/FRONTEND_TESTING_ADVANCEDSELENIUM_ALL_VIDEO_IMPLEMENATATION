package practice.home_Assertiontest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {

	@Test
	public void homepageTest(Method mtd) {
		
		System.out.println(mtd.getName() + "\t" +  "Test Start");
		String expectedPage = "HomePage";
		
		WebDriver driver = new ChromeDriver();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888/");

	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
		
	
	String actTitle= driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	
	/*
	 * if(actTitle.trim().equals(expectedPage)) { System.out.println(expectedPage +
	 * " Page is verified ==== PASS"); } else { System.out.println(expectedPage +
	 * "Page is not verified === FAIL"); }
	 */

	//HARD ASSERT
      Assert.assertEquals(actTitle,expectedPage);
	
      driver.quit();
	System.out.println(mtd.getName()+ "\t" + "Test End");
	}

	@Test
	public void VerifyLogoHomepageTest(Method mtd) {
		
		System.out.println(mtd.getName() + "\t" +  "Test Start");
		
		WebDriver driver = new ChromeDriver();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888/");

	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	boolean status = driver.findElement(By.xpath("//img[@title ='vtiger-crm-logo.gif']")).isEnabled();
	
	/* if(status) {
		System.out.println(expectedPage + " Logo is verified ==== PASS");
	}
	else {
		System.out.println(expectedPage + "Logo is not verified === FAIL");
	}
	*/
	
	//HARD ASSERT
	Assert.assertTrue(status);
	
	driver.quit();
	System.out.println(mtd.getName()+ "\t" + "Test End");
	}
}
