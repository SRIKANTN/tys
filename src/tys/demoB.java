package tys;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Ignore;
@Ignore
public class demoB 
{
	static WebDriver driver;
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	public static void captureElementScreenShot(WebElement element, String name) throws IOException
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		int imgWidth = element.getSize().getWidth();
		int imgHeight = element.getSize().getHeight();
	
		
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
	
		BufferedImage img = ImageIO.read(src);
		BufferedImage dest = img.getSubimage(xcord, ycord, imgWidth, imgHeight);
		ImageIO.write(dest,"png", src);
		
		FileUtils.copyFile(src, new File(name+".png"));
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		 driver= new  FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://www.irctc.com/displayServlet");
	//	captureElementScreenShot(driver.findElement(By.xpath("(//a[@target='_blank']/img)[4]")));
		driver.close();
		
	}

}
