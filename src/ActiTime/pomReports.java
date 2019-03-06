package ActiTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomReports 
{
	//public  WebDriver driver;
	//@FindBy(xpath="//*[@class='amcharts-pie-slice']")
	//private List<WebElement> reportsxp;
	@FindBy(xpath="//div[@id='createChartLightbox_cancelBtn']")
	private WebElement closeBT;
	
	public pomReports(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void reportsList() throws InterruptedException
	{
		//Actions act = new Actions(driver);
		//int count = reportsxp.size();
		closeBT.click();
//		for(WebElement ele  : reportsxp)
//		{
//		act.moveToElement(ele).perform();
//		Thread.sleep(1000);
//		}
	}

}
