package GaneshBorkar.JobSearch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.N_UpdateProfile;
import pageObject.NaukriLogin;
import resources.Base;

public class Naukri extends Base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void invoke() throws InterruptedException, IOException {
		
		driver = intialize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void login() throws IOException, InterruptedException {
		NaukriLogin l= new NaukriLogin(driver);
		l.getNaukriLogin();
		Thread.sleep(4000);
		
	}
	
	@Test(priority=1, enabled= true)
	public void updateProfile() throws InterruptedException {
		N_UpdateProfile uP = new N_UpdateProfile(driver);
		uP.getUpdateProfile();
	}
	
	@AfterTest
	public void tearApart() {
		driver.quit();
	}

	
	

}
