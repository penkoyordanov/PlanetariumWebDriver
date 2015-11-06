package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageObjects.Browser;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTests {
	private String userName="penko@icb.bg";
	private String password="123456";
	
	@Before
	public void setUp(){
		Browser.init();
	}
	
	@Test
	// Login with valid username and password
	public void loginSuccessfully(){
		HomePage homepage=new HomePage();
		homepage.get();
		LoginPage loginPage=homepage.clickLogin();
		loginPage.get();
		loginPage.login(userName, password);
		homepage.get();
		homepage.assertUserLoggedIn();
	}
	
	// Try to login without providing username and password
	@Test
	public void AttemptLogginWtihoutUsernamePass(){
		HomePage homepage=new HomePage();
		homepage.get();
		LoginPage loginPage=homepage.clickLogin();
		loginPage.get();
		loginPage.negativeLogin("", "");
		loginPage.assertErrorMessage(LoginPage.usernameWarning, "The field Username is required.");
		loginPage.assertErrorMessage(LoginPage.passwordWarning, "The field Password is required.");
		
		
	}
	
	// Try to login with wrong username and password
	@Test
	public void AttemptLogginWrongUsernamePass(){
		HomePage homepage=new HomePage();
		homepage.get();
		LoginPage loginPage=homepage.clickLogin();
		loginPage.get();
		loginPage.negativeLogin("tralala", "123");
		loginPage.assertErrorMessage(LoginPage.invalidLoginAttemptWarning, "Invalid login attempt.");
	}
	
	// Try to login with without password
		@Test
		public void AttemptLogginWithoutPass(){
			HomePage homepage=new HomePage();
			homepage.get();
			LoginPage loginPage=homepage.clickLogin();
			loginPage.get();
			loginPage.negativeLogin("tralala", "");
			loginPage.assertErrorMessage(LoginPage.passwordWarning, "The field Password is required.");
		}
		
		// Try to login with without username
		@Test
		public void AttemptLogginWithoutUsername(){
			HomePage homepage=new HomePage();
			homepage.get();
			LoginPage loginPage=homepage.clickLogin();
			loginPage.get();
			loginPage.negativeLogin("", "123456");
			loginPage.assertErrorMessage(LoginPage.usernameWarning, "The field Username is required.");
		}
	
	@After
	public void shutDown(){
		Browser.quit();
	}

}
