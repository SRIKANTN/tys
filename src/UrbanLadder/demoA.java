package UrbanLadder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoA 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	public static void main(String[] args) throws  Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.urbanladder.com");
		//driver.findElement(By.xpath("//a[contains(.,'Close')]")).click();
		Thread.sleep(2000);
		List<WebElement> allMenu = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul/li"));
		List<WebElement> submenu = driver.findElements(By.xpath("//div[@class='taxontype']"));
		List<WebElement> allsubmenu = driver.findElements(By.xpath("//ul[@class='taxonslist']//li"));
		
		Actions act = new Actions(driver);
		for(WebElement menu : allMenu)
		{
			//
			
			act.moveToElement(menu).perform();
			System.out.println(menu.getText());System.out.println("===========================");
			//Thread.sleep(1000);
			Thread.sleep(1000);
			for(WebElement el1 : submenu)
			{
				if(el1.isDisplayed())
				{
					System.out.println(el1.getText());
					System.out.println("---------------------");
				Thread.sleep(1000);
				for(WebElement all : allsubmenu)
				{
					if(all.isDisplayed())
					{
						System.out.println(all.getText());
						
					}
				}
				}
				System.out.println("===========================");
				//Thread.sleep(1000);
			}
			
		}
		Thread.sleep(2000);
		driver.close();
	}
}
