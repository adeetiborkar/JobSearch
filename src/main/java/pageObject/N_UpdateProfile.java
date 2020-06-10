package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class N_UpdateProfile {
	private WebDriver driver;
	
	public N_UpdateProfile(WebDriver driver) {
		this.driver= driver;
	}

	private By update= By.xpath("//div[@class='btn btn-block btn-large white-text']");
	private By myNaukri = By.xpath("//div[contains(text(),'My Naukri')]");
	private By logout = By.xpath("//li//a[@class='logout-gnb']");
	private By cookei = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/button");
	
	private By editHeadline = By.xpath("//div[@id='lazyResumeHead']//div//div//div//div//span[contains(text(),'Edit')]");
	public WebDriver getUpdateProfile() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(update).click();
		driver.findElement(cookei).click();
		Thread.sleep(5000);
		Actions a =new Actions(driver);

		driver.findElement(editHeadline).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[5]/div[8]/div[2]/form/div[3]/div/button")).click();
		
		a.moveToElement(driver.findElement(myNaukri)).build().perform();
		a.moveToElement(driver.findElement(logout)).click().build().perform();
		return driver;
	}
	
	
}
