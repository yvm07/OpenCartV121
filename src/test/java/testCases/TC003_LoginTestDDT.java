package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginTestDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups={"Datadriven", "Master"})	//getting dataprovider from different package,class
	public void verify_loginDDT(String email, String password, String exp)
	{
		
		logger.info("******* Starting TC003_LoginTestDDT************");
		
		try {
			
		//HomePage
		logger.info("HomePage start");
		HomePage hp = new HomePage(driver);
		logger.info("HomePage click on acc");
		hp.clickMyAccount();
		logger.info("HomePage click on login");
		hp.clickLogin();
		logger.info("HomePage done");
		
		//LoginPage
		logger.info("loginpage start");
		LoginPage lp = new LoginPage(driver);
		logger.info("login fill details");
		lp.fillEmail(email);
		lp.fillPassword(password);
		lp.clickLogin();
		logger.info("LoginPage done");
		
		//MyAccount
		logger.info("111111");
		MyAccountPage map = new MyAccountPage(driver);
		logger.info("222222");
		boolean targetPage = map.isMyAccountPageExists();
		
//		//Data is valid	-	login success - test pass - logout
//							login failed -	test fail
//		
//		//Data is invalid	-	login success - test fail - logout
//								login failed - test pass
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
			

		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		finally {
		logger.info("******* Starting TC003_LoginTestDDT************");
		}
	}
	
}
