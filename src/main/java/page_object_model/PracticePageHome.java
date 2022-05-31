package page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PracticePageHome {
	WebDriver driver;
	
	@FindBy(id = "checkBoxOption1")
	private WebElement checkBoxOption1;
	
	@FindBy(id = "checkBoxOption2")
	private WebElement checkBoxOption2;
	
	@FindBy(id = "checkBoxOption3")
	private WebElement checkBoxOption3;
	
	//Constructor
	
	public PracticePageHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCheckBoxOption1() {
		return checkBoxOption1;
	}
	
	public WebElement getCheckBoxOption2() {
		return checkBoxOption2;
	}
	
	public WebElement getCheckBoxOption3() {
		return checkBoxOption3;
	}
	
	public int getNumberBoxes() {
		return driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	}


}
