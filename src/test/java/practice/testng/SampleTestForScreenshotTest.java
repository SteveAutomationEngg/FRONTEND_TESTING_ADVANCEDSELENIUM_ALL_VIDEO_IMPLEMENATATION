package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshotTest {

	@Test
	public void amazonTest() throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// step-1 :create an object to EventFiring WebDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);

		// step2: use getSceenshotAs method to get file type of screenshot
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);

		// step3:store screen on local driver
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
		 
		/*
		String testName	=result.getMethod().getMethodName();
		FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+".png")); 
         */
		
		driver.quit();
	}
}
