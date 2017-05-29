package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private static WebElement element = null;
	private static Logger log= Logger.getLogger(HomePage.class);
	
	public static WebElement lnk_signIn(WebDriver driver)
	{
			String printCurrentFunctionName=new Object(){}.getClass().getEnclosingMethod().getName();
			log.info("Entering into Function - "+printCurrentFunctionName);
			element=driver.findElement(By.linkText("Sign In"));
			if (!element.isDisplayed())
			{
				log.error(element +" is not displayed");
				return element;
			}
			else
			{
				log.info(element +" is displayed successfully");
				return element;
			}		
	}
}
