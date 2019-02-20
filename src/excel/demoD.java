package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class demoD 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream file = new FileInputStream(new File("Data/demo1.xlsx"));
//		String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
//		System.out.println(data);
//		System.out.println();
//		Workbook wb = WorkbookFactory.create(file);
//		Sheet sh = wb.getSheet("Sheet1");
//		
//		//Row r = null;
//		Row r = sh.getRow(14);
//		Cell c = r.getCell(3);
//		c = r.createCell(15);
//		c.setCellValue("123654");
//		FileOutputStream fos = new FileOutputStream(new File("Data/input.xlsx"));
//		wb.write(fos);
//		file.close();
//		fos.close();
//		System.out.println("==========================");
//		
//		
//		Row r = sh.createRow(4);
//		Cell c = r.createCell(2);
//		c.setCellValue("srikanth111");
//		FileOutputStream fos = new FileOutputStream(new File("Data/demo1.xlsx"));
//		wb.close();
//		file.close();
//		fos.close();
//		System.out.println("=====================");
//		Workbook wb = WorkbookFactory.create(file);
//		 Sheet sh = wb.createSheet("Sheee");
//		 Row r = sh.createRow(2);
//		 r.createCell(2).setCellValue("srikanth");
//		
//		FileOutputStream fos = new  FileOutputStream(new File("Data/demo1.xlsx"));
//		wb.write(fos);
//		wb.close();
//		file.close();
//		fos.close();
//		System.out.println("==========================");
//		 Workbook wb = WorkbookFactory.create(file);
//		 SpreadsheetVersion v = wb.getSpreadsheetVersion();
//		 System.out.println(v);
//		 System.out.println(v.getLastColumnIndex());
//		 System.out.println(v.getLastColumnName());
//		 System.out.println(v.getLastRowIndex());
//		 System.out.println(v.getMaxColumns());
//		 System.out.println(v.getMaxCellStyles());
//		 System.out.println(v.getMaxFunctionArgs());
	}

}
