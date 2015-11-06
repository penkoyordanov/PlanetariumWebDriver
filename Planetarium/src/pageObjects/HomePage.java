package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class HomePage extends LoadableComponent<HomePage>{
	static String url="http://planetariumdev.icb.bg/en-us";
	private static String title ="Planetarium - Home";
	
	public HomePage() {
		PageFactory.initElements(Browser.driver, this);
	}
	
//	public HomePage(FirefoxProfile profile) {
//		PageFactory.initElements(Browser.driver, this);
//	}
	
	@FindBy (how=How.ID, using= "loginLink")
	WebElement loginLink;
	
	@FindBy (how=How.ID, using= "registerLink")
	WebElement registerLink;
	
	@FindBy (how=How.PARTIAL_LINK_TEXT, using= "Hello, Penko!")
	WebElement loggedUser;

	@Override
	protected void load() {
	Browser.open(url);
		
	}
	
	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(Browser.driver.getTitle().equals(title));
	}
	
	public void quit(){
		Browser.quit();
	}
	
	public LoginPage clickLogin(){
		loginLink.click();
		return PageFactory.initElements(Browser.driver, LoginPage.class);
	}
	
	public RegisterPage clickRegister(){
		registerLink.click();
		return PageFactory.initElements(Browser.driver, RegisterPage.class);
	}
	
	public void assertUserLoggedIn(){
		Assert.assertTrue(loggedUser.isDisplayed());
	}

	

}
