package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Browser {
	
	
	public static WebDriver driver;
	public static FirefoxProfile profile;
	
	public Browser(){
		
	}
	
//	public static WebDriver driver(){
//		return driver;
//	}
	
	public static void init(){
		profile=new FirefoxProfile();
		profile.setPreference("geo.enabled", false);
		driver=new FirefoxDriver(profile);
	} 
	
	public static void open(String url){
		driver.get(url);
	}
	
	public static void quit(){
		driver.quit();
	}
	
	
}
