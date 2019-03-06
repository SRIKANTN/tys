package UrbanLadder;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class A1 {
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	
	@Test
	public void testA()
	{
		Reporter.log("HELLO",true);
	}

}
