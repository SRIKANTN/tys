package excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demoE 
{
	public static  String getdatatoexcel(int rn, int cn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File("Data/demo1.xlsx"));
			Workbook wb = WorkbookFactory.create(file);
			return wb.getSheet("Sheet1").getRow(rn).getCell(cn).getStringCellValue();
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[4][2];
		data[0][0] = getdatatoexcel(1, 0);
		data[0][1] = getdatatoexcel(1, 1);
		data[1][0] = getdatatoexcel(2, 0);
		data[1][1] = getdatatoexcel(2, 1);
		data[2][0] = getdatatoexcel(3, 0);
		data[2][1] = getdatatoexcel(3, 1);
		data[3][0] = getdatatoexcel(4, 0);
		data[3][1] = getdatatoexcel(4, 1);
		return data;
	}
	@Test(dataProvider="getData")
	public void testdata(Object un ,Object pw)
	{
		System.out.println("user name= "+un+"  password= "+pw);
	}

}
