package ActiTime;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class reports 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	public static void main(String[] args) throws  Exception 
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
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[.='REPORTS']")).click();
		driver.findElement(By.id("ext-gen38")).click();
		List<WebElement> report = driver.findElements(By.xpath("//*[@class='amcharts-graph-column-front amcharts-graph-column-element']"));
		Thread.sleep(5000);
		for(WebElement rep : report)
		{
			Actions act = new Actions(driver);
			act.moveToElement(rep).perform();
			Thread.sleep(1000);
			break;
		}
	}
}
