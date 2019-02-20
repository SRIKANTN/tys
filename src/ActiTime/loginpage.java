package ActiTime;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import tys.demoB;

public class loginpage
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	}
	public static void main(String[] args) throws  Exception 
	{
		Properties pro = new Properties();
		pro.load(new FileInputStream("Data/xpath.properties "));
		Properties pro1 = new Properties();
		pro1.load(new FileInputStream("Data/loginPageData.properties"));
		WebDriver driver = new ChromeDriver();
		driver.get(pro.getProperty("url"));
		driver.findElement(By.xpath(pro.getProperty("username"))).sendKeys(pro1.getProperty("username"));
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys(pro1.getProperty("password"));
		driver.findElement(By.xpath(pro.getProperty("login"))).click();
		Thread.sleep(2000);
		List<WebElement> allimg = driver.findElements(By.xpath(pro.getProperty("img")));
		for(WebElement img : allimg)
		{
			String name = img.getText();
			System.out.println(img);
//			demoB.captureElementScreenShot(img,"demo1");
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		driver.close();
	}

}
