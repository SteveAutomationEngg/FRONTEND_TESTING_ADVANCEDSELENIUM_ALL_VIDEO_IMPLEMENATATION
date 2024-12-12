package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTestingFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
	
		// step1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\MOHIT KUMAR\\Desktop\\commondata.properties");
		
				//step2: Using Properties class , load all the keys
				
				Properties pObj = new Properties();
				pObj.load(fis);
				
				//step3: get the value based on key
			System.out.println(pObj.getProperty("browser"));			
			System.out.println(pObj.getProperty("url"));			
			System.out.println(pObj.getProperty("username"));			
			System.out.println(pObj.getProperty("password"));			

			
	}

}
