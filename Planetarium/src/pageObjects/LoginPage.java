package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPage extends LoadableComponent<LoginPage>{
	private String title="Planetarium - Login";
	
	@FindBy (how=How.PARTIAL_LINK_TEXT,using="Forgot your")
	WebElement forgotPassLnk;
	
	@FindBy(how=How.ID, using="Username")
	WebElement userNameField;
	
	@FindBy(how=How.ID, using="Password")
	WebElement passwordField;
	
	@FindBy(how=How.CSS, using="[value='Login']")
	WebElement loginBtn;
	
	@FindBy(how=How.CSS, using="[data-valmsg-for='Username']")
	public static WebElement usernameWarning;
	
	@FindBy(how=How.CSS, using="[data-valmsg-for='Password']")
	public static WebElement passwordWarning;
	
	@FindBy(how=How.XPATH, using="//form/div[1]/ul/li")
	public static WebElement invalidLoginAttemptWarning;
	
	

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(Browser.driver.getTitle().equals(title));
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	public ForgotPassword clickForgotPassLnk(){
		forgotPassLnk.click();
		return PageFactory.initElements(Browser.driver, ForgotPassword.class);
	}
	
	public HomePage login(String username, String password){
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		return PageFactory.initElements(Browser.driver, HomePage.class);
	}
	
	public void negativeLogin(String username, String password){
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

	public void assertErrorMessage(WebElement warning,String errorMessageToAssert){
		
		Assert.assertEquals(warning.getText(), errorMessageToAssert,"The validation message for the login form is not as expected");
		Assert.assertTrue(loginBtn.isDisplayed());
	}
}
