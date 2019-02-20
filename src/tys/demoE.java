package tys;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hdgf.pointers.Pointer;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class demoE extends demoF
{
	static WebDriver driver;
	static
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	/***
	 * @author srikanth
	 * @category takeScreen Shot ths specide element
	 * @throws null {@link Pointer} 
	 */
	public static void captureElementScreenShot(WebElement element,String name) 
	{
		try
		{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//get the size of the element
		int imgWidth = element.getSize().getWidth();
		int imgHeight = element.getSize().getHeight();
		//get the location of element
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
	
		BufferedImage img = ImageIO.read(src);
		BufferedImage dest = img.getSubimage(xcord, ycord, imgWidth, imgHeight);
		ImageIO.write(dest,"png", src);
		FileUtils.copyFile(src, new File(name+".png"));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testData()
	{
			driver= new  FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("http://www.irctc.com/displayServlet");
			demoE.captureElementScreenShot(driver.findElement(By.xpath("(//a[@target='_blank']/img)[4]")),"demo");
			driver.close();
	}
	
	

}
