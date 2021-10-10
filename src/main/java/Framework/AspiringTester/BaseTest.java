package Framework.AspiringTester;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	//public static WebDriver driver;
	public static WebDriver driver;
	public static Properties prop;
	
	@Test
	public static WebDriver getDriver() throws IOException, InterruptedException {
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\61468\\eclipse-workspace\\listeners\\AspiringTester\\src\\main\\java\\Framework\\AspiringTester\\global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")){
			
			 WebDriverManager.chromedriver().setup();
			
			 driver = new ChromeDriver();
			
			  
			
		      }else
		      {
		    	  WebDriverManager.firefoxdriver().setup();
		    	  driver = new FirefoxDriver();
		    	 
		      }
		         
		
		
		 return driver;
		
	}
	
	
	public static String getWebpage() throws IOException {
		
		 prop = new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\61468\\eclipse-workspace\\listeners\\AspiringTester\\src\\main\\java\\Framework\\AspiringTester\\global.properties");
			prop.load(fis);
		String page = prop.getProperty("url");
		
		return page;
	}
	
	
	public String getScreenShot(String testName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testName+".png";
	FileUtils.copyFile(source, new File(destinationFile));
	
	return destinationFile;
	}
	
	
	

}
