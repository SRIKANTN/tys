package extentreport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DemoA 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	
	static ExtentReports reports;
	static ExtentTest test;
	
	@BeforeSuite
	public void starttest()
	{
		 reports = new ExtentReports("./Reports/ExtentReportResults.html");
		 test = reports.startTest("extentReportsDemo");
		 
	}
	@AfterSuite
	public void endtest()
	{
		reports.endTest(test);
		reports.flush();
	}
	@Test
	public void reportsDemo() throws FileNotFoundException, IOException
	{
		Properties pro = new Properties();
		pro.load(new FileInputStream("Data/xpath.properties "));
		Properties pro1 = new Properties();
		pro1.load(new FileInputStream("Data/loginPageData.properties"));
		WebDriver driver = new FirefoxDriver();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(pro.getProperty("username"))).sendKeys(pro1.getProperty("username"));
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys(pro1.getProperty("password"));
		driver.findElement(By.xpath(pro.getProperty("login"))).click();
		
		
	}
}
