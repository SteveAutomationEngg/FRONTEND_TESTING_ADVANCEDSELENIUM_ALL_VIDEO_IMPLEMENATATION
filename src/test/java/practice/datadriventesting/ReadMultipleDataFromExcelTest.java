package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
FileInputStream fis= new FileInputStream("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\TestScriptDataTekpyramid.xlsx");
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("sheet1");
		
		//this getLastRowNum method fetch the last index of the excel sheet
		int rowCount = sh.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			
		Row row = sh.getRow(i);
		String Column1Data = row.getCell(0).toString();
		String Column2Data = row.getCell(1).toString();
		
		System.out.println(Column1Data + "\t" + Column2Data);
		 
		}
		
	wb.close();	

	}

}
