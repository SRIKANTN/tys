package tys;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demoF 
{
//	static
//	{
//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//	}
	public WebDriver driver;
	@BeforeMethod
	@Parameters({"nodeurl","browser"})
	public void preCondition(String nodeurl,String browser) throws MalformedURLException
	{
		URL url = new URL(nodeurl);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver= new RemoteWebDriver(url, dc);
		driver.get("https://www.google.com");
		
	}
	
	@AfterMethod
	void postCondition()
	{
		driver.close();
		
	}
}
