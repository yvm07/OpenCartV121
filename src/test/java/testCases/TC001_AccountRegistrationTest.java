package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.RegistrationSuccessPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void fill_Details() throws InterruptedException {
		String random = randomeString();
		String phone = randomeNumber();
		String password = randomePassword();

		logger.info("*******Starting TC001_FillDetailsTest******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*Clicked on My Account...*");
			hp.clickRegister();
			logger.info("*Clicked on Register...*");

			AccountRegistrationPage reg = new AccountRegistrationPage(driver);

			logger.info("*Providing customer details..*");
			reg.fillFirstName(random);
			reg.fillLastName(random);
			reg.fillEmail(random + "@test.com");
			reg.fillTelephone(phone);
			reg.fillPassword(password);
			reg.fillConfirmPassword(password);
			reg.clickNewsletter();
			reg.clickPolicy();
			reg.clickContinue();

			logger.info("*Validating expected message...*");
			String confmsg = reg.getMsgConfirmation();
			if(confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test failed");
				logger.info("Test Failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			Assert.fail();
		}

		logger.info("*******Finishing TC001_FillDetailsTest******");

	}

}
