package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	//constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement txtMyAccount;
		
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	
	//Methods
	public Boolean isMyAccountPageExists() {
		
		try {
			return(txtMyAccount.isDisplayed());
		}
	   catch(Exception e)
		{
		   return false;
		}
		
	}
	
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
