package practice.orgtest;

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

public class CreateOrganizationTest {
	
		public static void main(String[] args) throws  Throwable {
			

			//read common data from Properties file
			FileInputStream fis = new FileInputStream("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\commondata.properties");
			
			Properties pObj = new Properties();
			pObj.load(fis);
			
		      String BROWSER = pObj.getProperty("browser");
		      String URL = pObj.getProperty("url");
		      String USERNAME = pObj.getProperty("username");
		      String PASSWORD= pObj.getProperty("password");
			
		      //Generate the Random Number
		      Random random = new Random();
		     int randomInt = random.nextInt(1000);
		      
		      //read test script data from Excel file
		      
				FileInputStream fis1= new FileInputStream("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\testscriptdata.xlsx");
				Workbook wb= WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("org");
			    Row row = sh.getRow(1);
				String orgName = row.getCell(2).toString()+ randomInt;
				wb.close();
		     
		      
		      
			WebDriver driver =null;
			
			if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			} else if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}else if (BROWSER.equals("edge"))  {
				driver = new EdgeDriver();
				} else {
					driver = new ChromeDriver();
				}
			
			//step1: login to app
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step2: navigate to organization module
			driver.findElement(By.linkText("Organizations")).click();
			
			//step3:click on "create Organization" button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//step4:enter all the details & create new organization
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			
			
			//Verify Header msg from Expected Result  
			/*[here we are verifying as per manual test case we are getting i.e [ ACC42 ] facebook123333444 - Organization Information
			 * which contains Org name]
			 */
			
			
		String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "header verified == PASS ");
		}else {
			System.out.println(orgName + " header is not verfied == FAIL");
		}
		
		
				
			//Verify  Header orgname info Expected Result       
		/*[Here we are verifing jo maine Oganization creation time paar name daala matches final jo aaya after organization creation]
		 * 
		 */
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + "is created == PASS ");
		}else {
			System.out.println(orgName + " is not created == FAIL");
		}
		
		System.out.println("orgName"+ "\t" +   orgName);
		System.out.println("actOrgName"+"\t"+    actOrgName);
		
			Thread.sleep(5000);			 
			//step5:Logout
			Actions act = new Actions(driver);  
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
			
			

	}

		
	}


