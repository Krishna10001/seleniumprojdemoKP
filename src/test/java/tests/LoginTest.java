package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountsPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropdown().click();
		//Thread.sleep(3000);
		
		log.debug("Clicked on My Account dropdown");
		
		landingPage.loginButton().click();
		//Thread.sleep(3000);
		
		log.debug("Clicked on login button");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.emailField().sendKeys(email);
		//Thread.sleep(3000);
		
		log.debug("Email address got entered");
		
		loginPage.pwdField().sendKeys(password);
		//Thread.sleep(3000);
		
		log.debug("Password got entered");
		
		loginPage.loginButton().click();
		//Thread.sleep(3000);
		
		log.debug("Clicked on login button");
		
		AccountsPage accountsPage = new AccountsPage(driver);
		
		String actualResult = null;
		
		try {
			if(accountsPage.editAccountInfo().isDisplayed())
				log.debug("User got logged in");
				actualResult = "Successfull";
			
		}catch(Exception e) {
			log.debug("User didn't logged in ");
			actualResult = "Failure";

		}
	
		//System.out.println(accountsPage.editAccountInfo().isDisplayed());
		//Thread.sleep(3000);
		Assert.assertEquals(actualResult, expectedResult);
		
		
	}
	
	@BeforeMethod
	public void openApplication() throws IOException, InterruptedException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		
		Object[][] data = {{"priyankamohite173@gmail.com","Priyanka@123","Successfull"},{"priyan73@gmil.com","Prka@123","Failure"}};
		return data;
	}

}
