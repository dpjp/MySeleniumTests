package automationFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.HomePage; 

public class HomePageTest {

	private static Properties properties;
	private static WebDriver driver = null;
	private static Logger log=Logger.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
  public void setUp() {
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\Browser drivers\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);   
	}
	
	@Test
	public void testLaunchHomepage() throws Exception {
		driver.get("https://www.basspro.com");
		HomePage.lnk_signIn(driver).click();
		
		Actions action= new Actions(driver);
		action.contextClick(); // performs right click on the webpage.
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
