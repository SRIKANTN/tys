package excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DemoB 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(new File("Data/input.xlsx"));
		Workbook wb = new XSSFWorkbook(file);
		Sheet sh = wb.getSheet("srikanth");
		Row r = null;
		if(sh!=null)
			r = sh.getRow(2);	
			Cell c = r.getCell(2);
			if(c==null)
			r.createCell(2);
			c.setCellValue("abc");
		FileOutputStream fos = new FileOutputStream(new File("Data/input.xlsx"));
		wb.write(fos);
		fos.close();
		wb.close();
		System.out.println("workbook closed");
		
			
	
	
			
		
	}

}
