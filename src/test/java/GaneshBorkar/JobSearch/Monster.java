package GaneshBorkar.JobSearch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;	
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.M_UpdateProfile;
import pageObject.MonsterLogin;
import resources.Base;

public class Monster extends Base {

	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = intialize();
		driver.get("https://www.monsterindia.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void login() throws IOException {
		MonsterLogin l = new MonsterLogin(driver);
		l.getJobseekerLogin();
	}

	@Test(priority = 2)
	public void updateProfile() throws InterruptedException {
		M_UpdateProfile up = new M_UpdateProfile(driver);
		up.GetUpdateProfile();

	}

	@AfterTest
	public void tearApart() {
		driver.quit();
	}
	

	
	
}
