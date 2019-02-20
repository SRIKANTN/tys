package tys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Ignore;
@Ignore
public class demoC extends AbstractWebDriverEventListener 
{
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	 public void  afterClickOn(WebDriver driver,WebElement element)
	 {
		 System.out.println("is clicked");
		 
	 }
	 public void afterChangeValue(WebElement element,WebDriver driver,java.lang.CharSequence[]keysToSend)
	 {
		 System.out.println("value entered");
	 }
	 public static void main(String[] args) 
	 {
		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver d = new EventFiringWebDriver(driver);
		demoC dd =new demoC();
		d.unregister(dd);
		driver.get("http://google.com");
		driver.switchTo().activeElement().sendKeys("java");
		driver.close();
		
	}
}
