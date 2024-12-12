package practice.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws Throwable {

		// In this Script we create one organization and then create Contact by using same org name

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
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		//wb.close();

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

		// Verify Header msg from Expected Result
		String orgHeaderInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeaderInfo.contains(orgName)) {
			System.out.println(orgName +"\t"+ "Org header verified == PASS ");
		} else {
			System.out.println(orgName +"\t"+ " Org header is not verfied == FAIL");
		}

		
		


		// read test script data from Excel file

		Sheet sh1 = wb.getSheet("contact");
		Row row1 = sh1.getRow(1);
		String lastName = row1.getCell(2).toString() + randomInt;
		wb.close();

		// step2: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// step3:click on "create contact" button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step4:enter all the details & create new contact
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

		driver.findElement(By
				.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']"))
				.click();
		
  //switch To Child Window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
		String actUrl	= driver.getCurrentUrl();
		if(actUrl.contains("module=Accounts")) {
			break;
		}
		
		}
		
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//Switch to parent Window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
		while(it1.hasNext()) {
			String windowID = it1.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Contacts&action")) {
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Verify contact info Expected Result 
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.equals(lastName)) {
			System.out.println(lastName + "\t" + "information is verified == PASS ");
		} else {
			System.out.println(lastName + "\t" + " information is not verfied == FAIL");
		}
		
		//verify org name info Expected result
	   String actOrgName	= driver.findElement(By.id("mouseArea_Organization Name")).getText();
	   System.out.println(actOrgName);
	   
	   if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "\t" + "information is verified == PASS ");
		} else {
			System.out.println(orgName + "\t" + " information is not verfied == FAIL");
		}
	   
	   //Verify Header Contact info expected Result
	  String contactHeaderInfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	  
	  if(contactHeaderInfo.contains(lastName)) {
		  System.out.println(lastName + "\t" + "information is verified == PASS ");
		} else {
			System.out.println(lastName + "\t" + " information is not verfied == FAIL");
		}
	   
		
		
		driver.quit();
		
		

	}

}
