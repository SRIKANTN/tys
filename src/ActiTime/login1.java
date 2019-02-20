package ActiTime;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login1 
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
		driver.findElement(By.xpath("//div[.='TASKS']")).click();
		driver.findElement(By.xpath("(//div[@class='downIcon'])[3]")).click();
		driver.findElement(By.xpath("//input[@class='customSelect checked']")).click();
		List<WebElement> alltask = driver.findElements(By.xpath(pro.getProperty("task")));
		for(WebElement task : alltask)
		{
			String text = task.getText();
			if(text.equals("Done"))
			{
				task.click();
				break;
			}
					
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='apply components_button']")).click();
		int count = driver.findElements(By.xpath("//table[@class='taskRowsTable']//tr")).size();
		System.out.println("status count= "+count);
		for(WebElement element : driver.findElements(By.xpath("//div[@class='timeEditor']")))
		{
			System.out.println(element.getText());
		}
		Thread.sleep(5000);	
		driver.close();
	}

}
