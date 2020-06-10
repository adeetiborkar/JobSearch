package pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaukriLogin {
	private WebDriver driver;
	private Properties prop;
	public NaukriLogin(WebDriver driver) {
		this.driver= driver;
	}

	private By login = By.xpath("//div[contains(text(),'Login')]");
	private By email = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/input[1]");
	private By psw = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[3]/input[1]");
	private By loginB= By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[5]/button[1]");
	
	public WebDriver getNaukriLogin() throws IOException, InterruptedException {
		
		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String mailId= prop.getProperty("mail");
		String pss = prop.getProperty("password");
		Thread.sleep(2000);
		driver.findElement(login).click();
		Thread.sleep(2000);
		driver.findElement(email).sendKeys(mailId);
		driver.findElement(psw).sendKeys(pss);
		driver.findElement(loginB).click();
		return driver;
	}
	
	
	
}
