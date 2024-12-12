package practice.extentReportTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTOutlinePrImpl;
import org.testng.ISuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport_attachscreenshot3Test {
	
	ExtentReports report;   //declare global as used in two block @BS and @AS [in real Framwork we write @AS code in Listener 
	                        //implementation class  onStart(ISuite suite),onFinish(ISuite suite) respectively.
	

	@BeforeSuite
	public void configBS() {
		//Spark report Configuration
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add Environment information
				report= new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Window-10");
				report.setSystemInfo("BROWSER", "Chrome-100");
		
	}
	
	
	@AfterSuite
	public void configAS() {
		//backup the report
		   report.flush();
		
	}
	
	
	@Test
	public void createContactTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		//take screenshot
		TakesScreenshot eDriver = (TakesScreenshot) driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
	
		//create test
		ExtentTest test = report.createTest("createContactTest");
		
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
		
			//if testcase fail it will take screenshot
			test.addScreenCaptureFromBase64String(filePath, "Error message");
		}
		
		driver.close();
	
	}
}
