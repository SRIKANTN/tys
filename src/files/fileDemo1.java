package files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class fileDemo1
{
	public static void main(String[] args) throws IOException 
	{
		Properties properties  = new Properties();
		FileInputStream file = new FileInputStream("Data/logging.properties");
		properties.load(file);
		System.out.println(properties.getProperty("user"));
		Set<Object> keys = properties.keySet();
		for(Object key : keys)
		{
			System.out.println("Key: "+key);
			System.out.println("value: "+properties.get(key));
		}
	
//	     String text = properties.getProperty("user");
//	     System.out.println(text);
//	     System.out.println(properties.getProperty("company1"));
//	     
		
		
	}

}
