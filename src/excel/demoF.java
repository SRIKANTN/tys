package excel;

import java.io.InputStream;
import java.util.Properties;

public class demoF 
{
	String result = " ";
	InputStream inputstream;
	public String getPoperties()
	{
		try
		{
			
		Properties prop = new Properties();
		
		String propFile = "Data/logging.properties";
		
		inputstream.getClass().getClassLoader().getResourceAsStream(propFile);
		if(inputstream != null)
		{
			prop.load(inputstream);
		}
		
		String user = prop.getProperty("user");
		String comp1 = prop.getProperty("company1");
		String comp2 = prop.getProperty("company2");
		String comp3 = prop.getProperty("company3");
		
		result  = "company list = " + comp1 + " "+ comp2 + " "+ comp3;
		System.out.println(result);
		return result;
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	public static void main(String[] args) {
		demoF d= new demoF();
		d.getPoperties();
	}

}
