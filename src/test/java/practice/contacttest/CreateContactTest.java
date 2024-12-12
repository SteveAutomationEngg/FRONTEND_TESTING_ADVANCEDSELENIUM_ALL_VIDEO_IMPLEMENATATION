package practice.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
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

public class CreateContactTest {
	public static void main(String[] args) throws Throwable {

		// read common data from Properties file
		FileInputStream fis = new FileInputStream(
				"D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		// Generate the Random Number
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		// read test script data from Excel file

		FileInputStream fis1 = new FileInputStream(
				"D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString() + randomInt;
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

		// step2: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// step3:click on "create contact" button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step4:enter all the details & create new contact
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		
		// Verify Header msg from Expected Result
         String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(headerInfo.contains(lastName)) {
			System.out.println(lastName + "\t" + " header verified == PASS ");
		} else {
			System.out.println(lastName + "\t" + " header is not verfied == FAIL");
		}
		
		
		
		// Verify Header Phone Number info Expected Result 
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.contains(lastName)) {
			System.out.println(lastName + "\t" + "information is verified == PASS ");
		} else {
			System.out.println(lastName + "\t" + " information is not verfied == FAIL");
		}

		Thread.sleep(5000);
		// step5:Logout
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
