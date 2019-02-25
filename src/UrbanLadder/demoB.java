package UrbanLadder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoB 
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
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("java",Keys.ENTER);
		List<WebElement> alllinkes = driver.findElements(By.xpath("//div[@id='rso']//h3"));
		int count = alllinkes.size();
		System.out.println(count);
		for (WebElement element : alllinkes) 
		{
			System.out.println(element.getText());
			
		}
		driver.close();
		
		
	}

}
