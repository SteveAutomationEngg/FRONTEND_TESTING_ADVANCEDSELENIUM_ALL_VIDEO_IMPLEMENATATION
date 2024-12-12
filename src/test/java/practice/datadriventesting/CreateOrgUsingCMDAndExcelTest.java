package practice.datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgUsingCMDAndExcelTest {

	
	@Test
	public void createOrgTest() throws Throwable {
		
		
		/* This is a real Selenium Program where i am fetching the common data from CMD line using Maven Parameters
		 * instead of Property file (99% CMD line is used to fetch common data from CMD line)
		 */
		// read common data from CMD line
        String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");

		// Generate the Random Number
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		// read test script data from Excel file

		FileInputStream fis1 = new FileInputStream(
				"D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\TestScriptDataTekpyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		wb.close();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// step1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step2: navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();

		// step3:click on "create Organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step4:enter all the details & create new organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(5000);

		// step5:Logout
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
