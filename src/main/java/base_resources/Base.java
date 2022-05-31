package base_resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver setUpWebdriver() throws IOException  
	{
		prop = new Properties();
		//Upload data.properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties");
		prop.load(fis);
		
		String timeOut = prop.getProperty("timeout");
		//String browser = prop.getProperty("browser");
		String browser = System.getProperty("browser");
		ChromeOptions options = new ChromeOptions();
		
		switch (browser) {
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			break;
			
		case "headless":
			options.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		case "ie":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		default:
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeOut)));
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
}
