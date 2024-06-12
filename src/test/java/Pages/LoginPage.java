package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(partialLinkText="Log out")
	WebElement logoutButton;
	
	public void guserName(String name) {
		username.sendKeys(name);
		
	}
	
	public void gpassWord(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void logIn() {
		loginButton.click();
	}
	
	public void logoutButton() {
		logoutButton.click();
	}
	
	

}
