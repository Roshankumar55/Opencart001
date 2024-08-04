package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@id='content']//h2[text()='My Account']")
	WebElement msgMyAccount;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement likLogout;
	
	public boolean ismyAccountPageExists() {
		try {
			return(msgMyAccount.isDisplayed());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void clkLogout() {
		likLogout.click();
	}
}
