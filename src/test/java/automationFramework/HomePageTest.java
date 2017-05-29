package automationFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.apache.log4j.xml.DOMConfigurator;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.annotations.Test;

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
		DOMConfigurator.configure("log4j.xml");
		log.info("In WebDriver initialization Method");
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\Browser drivers\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Launching Firefox WebDriver");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void testLaunchHomepage() throws Exception {
		log.info("Navigating to Basspro.com site");
		driver.get("https://www.basspro.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		log.info("Website Launched Successfully");
		HomePage.lnk_signIn(driver).click();
		log.info("Clicked on Sign In link in the homePage");
		Actions action= new Actions(driver);
		log.info("Perform Right Click Operation");
		action.contextClick(); // performs right click on the webpage.
		Thread.sleep(2000);
		log.info("Right click Operation Performed Successfully");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		log.info("Entered into TearDown Method to kill browser");
		driver.quit();
		log.info("Browser closed Successfully");
	}
}
