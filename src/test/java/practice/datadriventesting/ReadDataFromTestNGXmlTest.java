package practice.datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXmlTest {

	@Test
	public void sampleTest(XmlTest test){
	
		System.out.println("Execute SampleTest");
		System.out.println(" YO Boys Kolaveri DI");
		System.out.println(test.getParameter("browser"));
	    System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
		
		/* in this script the browser,url,username,password is get read from it's testNG.xml file 
		 * for that Run the testng.xml file instead of this class so that this script fetch the data from xml
		 * but if u run this class all parameter i.e browser,url,username,password will be null (default value).
		 */
	}

}
