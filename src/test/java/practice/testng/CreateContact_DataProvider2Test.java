package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider2Test {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName, String lastName, long phoneNumber)
	{
		System.out.println("First Name: "+ firstName + "\t" + "Last Name: "+ lastName + "\t" + "Phone Number :"+ phoneNumber);
	}

	
	@DataProvider
	public Object getData() {
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]= "deepak";
		objArr[0][1]= "HR";
		objArr[0][2]= 9856231472l;
		
		
		objArr[1][0]= "sam";
		objArr[1][1]= "sharma";
		objArr[1][2]= 9856231482l;
		
		objArr[2][0]= "john";
		objArr[2][1]= "smith";
		objArr[2][2]= 9856231462l;
		
		return objArr;
	
	
}
}
