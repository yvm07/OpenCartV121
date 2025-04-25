package testCases;

import org.testng.annotations.Test;

import utilities.DataProviders;

public class LoginDataTest {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void getLogin(String email, String password, String exp)
	{
		System.out.println("email--->"+email);
		System.out.println("password--->"+password);
		System.out.println("exp--->"+exp);
	}
}
