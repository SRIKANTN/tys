package nag;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UrbanLadder {
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
		driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		Actions act=new Actions(driver);
		List<WebElement> allMenu = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul/li/span"));
		for(WebElement we: allMenu)
		{
			Thread.sleep(1000);
				act.moveToElement(we).perform();
				String var1 = we.getText();
				System.out.println(var1);
				List<WebElement> subMenu = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul/li/span[contains(text(),'"+var1+"')]/following-sibling::div/descendant::div[@class='taxontype']"));
				for(WebElement we1:subMenu)
				{
					Thread.sleep(1000);
					String var2=we1.getText();
					System.out.println(var2);
					System.out.println("-----------------------------------------------");
					List<WebElement> miniMenu = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul/li/span[contains(.,'"+var1+"')]/following-sibling::div/descendant::div[@class='taxontype']/a[.='"+var2+"']/parent::div/following-sibling::ul/li/a"));
					for(WebElement we2:miniMenu)
					{
						String var3=we2.getText();
						System.out.println(var3);
					}
				}
				System.out.println("=======================================================================");
				
		}
	}
}