package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String expectedTestcaseId = "tc_01";
		String data1="";
		String data2="";
		String data3="";
		String data="";
		
		boolean flag= false;

		FileInputStream fis = new FileInputStream(
				"D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\TestScriptDataTekpyramid.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("org");

		int rowCount = sh.getLastRowNum();

		for (int i = 0; i <= rowCount; i++) {
            
			
			try {
				data = sh.getRow(i).getCell(0).toString();

				if (data.equals(expectedTestcaseId)) {
					 
					 flag= true;
					 data1 = sh.getRow(i).getCell(1).toString();
			         data2 = sh.getRow(i).getCell(2).toString();
					 data3 = sh.getRow(i).getCell(3).toString();
					
				}
			} catch (Exception e) {
			}
		}
			if(flag == true) {
				System.out.println(data);
				System.out.println(data1);
				System.out.println(data2);
				System.out.println(data3);
			}
			else {
				System.out.println(expectedTestcaseId+  "data is not available");
			}
          
			wb.close();
			
		

	}
}
