package tys;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
@Ignore
public class demoA
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	public void waitForLoad(WebDriver driver)
	{
		ExpectedCondition<Boolean> pageLoadcondition = new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
	return 
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"); 
						
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(pageLoadcondition);
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.irctc.com/");
		WebElement a = driver.findElement(By.className("main_button_typ_004"));
		String namea = a.getText();
		demoE.captureElementScreenShot(a, namea);
		a.click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itrwin = win.iterator();
		String strparentwin = itrwin.next();
		String strchildwin1 = itrwin.next();
		driver.switchTo().window(strchildwin1);
		WebElement b = driver.findElement(By.className("Flights"));
		String nameb =b.getText();
		demoE.captureElementScreenShot(b, nameb);
		b.click();
		win =driver.getWindowHandles();
		itrwin = win.iterator();
		itrwin.next();
		itrwin.next();
		String strchildwin2 = itrwin.next();
		driver.switchTo().window(strchildwin2);
		WebElement frstclick = driver.findElement(By.className("hotel-stay"));
		String name = frstclick.getText();
		demoE.captureElementScreenShot(frstclick, name);
		frstclick.click();
		win =driver.getWindowHandles();
		itrwin = win.iterator();
		itrwin.next();
		itrwin.next();
		itrwin.next();
		String strchildwin3 = itrwin.next();
		driver.switchTo().window(strchildwin3);
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(strchildwin2);
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(strchildwin1);
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(strparentwin);
		Thread.sleep(2000);
		driver.close();
		
	}
	
}
