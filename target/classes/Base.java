package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	WebDriver driver;
	
	public WebDriver intialize() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

		
	}
	
	


}
