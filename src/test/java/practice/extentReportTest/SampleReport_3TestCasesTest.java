package practice.extentReportTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport_3TestCasesTest {
	
	ExtentReports report;
	
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
		
		//backup of report
		 report.flush();
	}
	
	
	@Test
	public void createContactTest() {
		
		//create test
		ExtentTest test = report.createTest("createContactTest");
		
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
		
	  
	}
	
	
	
	@Test
	public void createContactWithPhoneNumberTest() {
		
		//create test
		ExtentTest test = report.createTest("createContactWithPhoneNumberTest");
		
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
		
	  
	}
	
	@Test
	public void createContactWithOrgTest() {
		
		//create test
		ExtentTest test = report.createTest("createContactWithOrgTest");
		
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
		
	  
	}
}
