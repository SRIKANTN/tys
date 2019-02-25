package ActiTime;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomReports 
{
	static WebDriver driver;
	@FindBy(xpath="//*[@class='amcharts-pie-slice']")
	private List<WebElement> reportsxp;
	public pomReports()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void reportsList() throws InterruptedException
	{
//		Actions act = new Actions(driver);
		int count = reportsxp.size();
		System.out.println(count);
//		for(WebElement ele  : reportsxp)
//		{
//		act.moveToElement(ele).perform();
//		Thread.sleep(1000);
//		}
	}

}
