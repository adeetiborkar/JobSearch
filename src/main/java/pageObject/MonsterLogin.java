package pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MonsterLogin {
	
	private WebDriver driver;
	private Properties prop;

	public MonsterLogin(WebDriver driver) {
		this.driver = driver;
		
	}
	private By jobseeker = By.xpath("//li[@id='seekerLoginBtn']/a");
	private By email= By.id("signInName");
	private By psw = By.id("password");
	private By login= By.cssSelector("#signInbtn");
	
	public WebDriver getJobseekerLogin() throws IOException {

		driver.findElement(jobseeker).click();

		prop = new Properties();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String mailId= prop.getProperty("mail");
		String pw= prop.getProperty("password");
		
		driver.findElement(email).sendKeys(mailId);
		driver.findElement(psw).sendKeys(pw);
		driver.findElement(login).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
