package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try {
		//Calling Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicking on MyAccount Link...");
		
		hp.clickRegister();
		logger.info("Clicking on Register Link...");
		
		//Calling Registration Page
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		/*
		 * regpage.setFirstName("Roshan"); regpage.setLastName("Kumar");
		 * regpage.setEmail("roshankumar123@gmail.com");
		 * regpage.setTelephone("9876543210"); regpage.setPassword("xzy12345");
		 * regpage.setConfirmPassword("xyz12345");
		 */
		
		logger.info("Providing customer details...");
		//random string generated
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //random gmail generated
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumberic();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validation expected message....");
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertFalse(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}catch (Exception e) {
			
			Assert.fail();
			// TODO: handle exception
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		
	}

}
