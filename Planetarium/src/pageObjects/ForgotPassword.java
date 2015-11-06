package pageObjects;

import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class ForgotPassword extends LoadableComponent<ForgotPassword>{
	String title="Planetarium - Forgot your password?";
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(Browser.driver.getTitle().equals(title));
	}

}
