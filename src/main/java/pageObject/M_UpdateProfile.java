package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class M_UpdateProfile {

	private  WebDriver driver;
	
	public M_UpdateProfile(WebDriver driver) {
		this.driver = driver;
	}
	
	private By updatePro = By.linkText("Update Profile");
	private By editPersonalD = By
			.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[1]/div[10]/div[1]/div[1]/a[1]/i[1]");
	private By male = By.xpath("//span[contains(text(),'Male')]");
	private By female = By.xpath("//span[contains(text(),'Female')]");
	private By save = By.xpath(
			"//div[@id='personalDetailsModal']//div[@id='modalDescription']//div//div//div//div//div//button[contains(text(),'Save')]");
	private By cross = By.xpath("//body/div[@id='profileThemeDefault']/div/div/div[@id='notificationHolder']/div/div/div/i[1]");
	private By proimg= By.className("profile-img-holder");
	private By logout = By.xpath("//a[contains(text(),'Logout')]");
	
	
	public WebDriver GetUpdateProfile() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(updatePro).click();
		driver.findElement(editPersonalD).click();
		driver.findElement(male).click();
		driver.findElement(female).click();
		driver.findElement(save).click();
		driver.findElement(cross).click();
		
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(proimg)).build().perform();
		a.moveToElement(driver.findElement(logout)).click().build().perform();
		
		return driver;
		
	}
	
	
	
	
}
