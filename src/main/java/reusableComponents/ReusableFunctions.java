package reusableComponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableFunctions {
	
	private static WebElement element = null;
	private static final Logger log = Logger.getLogger(ReusableFunctions.class);
	
	public static WebElement LinkText(WebDriver driver, String inputLink)
	{
		element = driver.findElement(By.linkText(inputLink));
		log.info("Link Element is - "+element);
		try
		{
			if(!element.isDisplayed())
			{
				log.error("Element - "+element+ " is not Displayed in the Webpage");
			}
			else
			{
				log.info("Element - "+element+ " is displayed");
			}
		}catch(Exception e){
			log.error("Exception caught was - "+e.getMessage());
		}
		return element;
	}

	
	
}
