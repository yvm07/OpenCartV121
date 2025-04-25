package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_FillLoginDetailsTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void fillLogin() {

		logger.info("******* Starting Login test *******");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*Clicked on My Account...*");
			hp.clickLogin();
			logger.info("*Clicked on Login...*");

			LoginPage lp = new LoginPage(driver);
			logger.info("*Entering Login Details...*");
			lp.fillEmail(p.getProperty("email"));
			lp.fillPassword(p.getProperty("password"));
			lp.clickLogin();
			
			
//			//map.clickLogout();
			
			MyAccountPage map = new MyAccountPage(driver);
			boolean result = map.isMyAccountPageExists();
//			Assert.assertTrue(result);
			
			if(result)
			{
				logger.info("*Checking the MyAccountPage...*");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("test failed");
				Assert.assertTrue(false);
			}
			

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("******* Finishing Login test *******");
	}

}
