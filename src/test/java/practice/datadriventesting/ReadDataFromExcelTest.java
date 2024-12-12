package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1: get the excel path location & java object of the physical file
		
		FileInputStream fis= new FileInputStream("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\TestScriptDataTekpyramid.xlsx");
		
		//step2:open workbook in read mode
		Workbook wb= WorkbookFactory.create(fis);
		
		//step3:get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");
		
		//step4:get the control of the 1st row
		Row row = sh.getRow(1);
		
		//step5:get the control of the "2nd" cell and read the String Data
		Cell cel = row.getCell(3);
		/* always prefer getStringCellValue() and convert the numeric value in the cell into 
		 * string by using apstrophe like '200 (BEST PRACTICE)
		 * u can also toString() then no need to convert the Excel numeric value to string it always give String as output
		 */
     String data	= cel.getStringCellValue();
     
     
    // double data = cel.getNumericCellValue();
     //	String data	= cel.toString();
     	
	    System.out.println(data);
		
	    
		//step 6: Close the WorkBook
	
	     wb.close();
		
		
	}		

}
