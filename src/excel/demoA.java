package excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demoA 
{
	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream(new File("Data/input.xlsx"));
		Workbook wb = new XSSFWorkbook(file);
		
		
		
		Iterator<Sheet> itr = wb.sheetIterator();
		while(itr.hasNext())
		{
			Sheet sh = itr.next();
			System.out.println(sh.getSheetName());
		}
		FileOutputStream fos = new FileOutputStream(new File("Data/input.xlsx"));
		wb.write(fos);
		wb.close();
		System.out.println("work book closed");
		
	}


}
