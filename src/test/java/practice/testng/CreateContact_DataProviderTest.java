package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProviderTest {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName, String lastName)
	{
		System.out.println("First Name: "+ firstName + "\t" + "Last Name: "+ lastName);
	}

	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]= "deepak";
		objArr[0][1]= "HR";
		
		objArr[1][0]= "sam";
		objArr[1][1]= "sharma";
		
		objArr[2][0]= "john";
		objArr[2][1]= "smith";
		
		return objArr;
	
	
}
}
