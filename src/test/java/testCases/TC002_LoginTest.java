package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void verify_login() {
		logger.info("********* Starting TC002_LoginTest*********");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clkLogin();

			// MyAccountPage
			MyAccountPage Myacc = new MyAccountPage(driver);
			boolean targetPage = Myacc.ismyAccountPageExists();

			Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true, "Login failed");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}

		logger.info("********* Finished TC002_LoginTest*********");
	}

}
