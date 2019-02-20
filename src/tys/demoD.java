package tys;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
@Ignore
public class demoD 
{
	static WebDriver driver;
	@Parameters({"nodeurl","browser"})
	@BeforeMethod
	public void precondition(String browser,String nodeurl) throws MalformedURLException, InterruptedException
	{
		URL url = new URL(nodeurl);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver = new RemoteWebDriver(url, dc);
		
		driver.get("https://www.google.com/");
		
			
	}
	@AfterMethod
	public void postcondition()
	{
		
		driver.close();
	}
	
}
