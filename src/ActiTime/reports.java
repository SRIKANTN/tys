package ActiTime;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class reports 
{
	public static WebDriver driver;
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	public static void main(String[] args) throws  Exception 
	{
		
		pomReports p = new pomReports(driver);
		Properties pro = new Properties();
		pro.load(new FileInputStream("Data/xpath.properties "));
		Properties pro1 = new Properties();
		pro1.load(new FileInputStream("Data/loginPageData.properties"));
		 driver = new ChromeDriver();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(pro.getProperty("username"))).sendKeys(pro1.getProperty("username"));
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys(pro1.getProperty("password"));
		driver.findElement(By.xpath(pro.getProperty("login"))).click();
		driver.findElement(By.xpath("//div[.='REPORTS']")).click();
		driver.findElement(By.id("ext-gen38")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("PIE_CHART")).click();
		Thread.sleep(1000);
		List<WebElement> allreports = driver.findElements(By.xpath("//*[@class='amcharts-pie-slice']"));
		List<WebElement> alltext = driver.findElements(By.xpath("//*[@font-size='11px']"));
//		driver.findElement(By.xpath("//div[@id='createChartLightbox_cancelBtn']")).click();
		Actions act= new Actions(driver);
		for(WebElement we : allreports)
		{
			
			
			for(WebElement text : alltext)
			{ 
				Thread.sleep(1000);
				act.moveToElement(we).perform();
				we.click();
				System.out.println(text.getText());
			}
		}
		Thread.sleep(2000);
		driver.close();
	}
}
