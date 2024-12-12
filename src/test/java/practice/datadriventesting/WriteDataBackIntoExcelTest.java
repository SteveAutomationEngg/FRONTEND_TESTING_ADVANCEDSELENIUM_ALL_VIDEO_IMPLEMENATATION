package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackIntoExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	FileInputStream fis = new FileInputStream("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\TestScriptDataTekpyramid.xlsx");

	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(4); 
	
	Cell cel = row.createCell(4);
	cel.setCellType(CellType.STRING);
	cel.setCellValue("PASS");
	
	
	FileOutputStream fos= new FileOutputStream("D:\\SELENIUM TEKPYRAMID TRAINING\\SeleniumCRMUIFramework\\src\\test\\resources\\TestScriptDataTekpyramid.xlsx");
	wb.write(fos);
	wb.close();
	
	
	System.out.println("===============Executed====================");
	
	}
}
