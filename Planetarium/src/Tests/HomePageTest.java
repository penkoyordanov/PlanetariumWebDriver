package Tests;

import org.junit.Test;
import org.testng.Assert;

import pageObjects.Browser;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest {
	
	@Test
	public void Test(){
		HomePage homePage=new HomePage();
		homePage.get();
		LoginPage loginPage=homePage.clickLogin();
		loginPage.get();
//		loginPage.clickForgotPassLnk();
		Browser.quit();
		
		
		
	}

}
