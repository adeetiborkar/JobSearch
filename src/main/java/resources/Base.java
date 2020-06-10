package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intialize() throws InterruptedException, IOException {
		
	    prop=new Properties();
		//System.getProperty("user.dir");  ==C:\\Users\\User\\Desktop\\New folder\\SeleniumWork\\E2EProject
	    
	    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
				
		String browserName= prop.getProperty("browser");
		if (browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
//run testcase without invoking browser use ChromeOption			
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
			{
			options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

		
	}
	
	


}
