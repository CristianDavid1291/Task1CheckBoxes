package test_cases;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_resources.Base;
import page_object_model.PracticePageHome;

public class CheckHomePage extends Base {
	
	public WebDriver driver;
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUpDriver() throws IOException
	{
		log.info("Starting test CheckHomePage");
		log.info("Creating web driver instance");
		driver = setUpWebdriver();
		log.info("Driver's instance created properly");
		driver.get(prop.getProperty("url"));
		log.info("Navigation to url: "+prop.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void validateCheckbox() 
	{
		log.info("Starting method: validateCheckbox");
		SoftAssert a = new SoftAssert();
		PracticePageHome ph = new PracticePageHome(driver);
		ph.getCheckBoxOption1().click();
		log.info("Selecting checkbox 1");
		a.assertTrue(ph.getCheckBoxOption1().isSelected(),"Checkbox1 not selected");
		log.info("Unselecting checkbox 1");
		ph.getCheckBoxOption1().click();
		a.assertFalse(ph.getCheckBoxOption1().isSelected(),"Checkbox1 selected");
		a.assertAll();
		log.info("Ending method: validateCheckbox");
	}
	
	@Test(priority = 2)
	public void countCheckBoxes()
	{
		log.info("Starting method: countCheckBoxes");
		PracticePageHome ph = new PracticePageHome(driver);
		log.info("Number of checkboxes: " + ph.getNumberBoxes());
		log.info("Ending method: countCheckBoxes");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		log.info("Ending test CheckHomePage");
		driver.close();
	}
	
	
	

}
