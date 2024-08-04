package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "input-email")
	WebElement txtemail;
	
	@FindBy(id = "input-password")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clkLogin() {
		btnLogin.click();
	}

}
