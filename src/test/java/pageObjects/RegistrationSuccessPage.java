package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationSuccessPage extends BasePage
{

	// constructor
		public RegistrationSuccessPage(WebDriver driver) {
			super(driver);
		}
		
		
	//locators
		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgSuccess;
		
		
	//Action Methods
		public String getMsgSuccess()
		{
			return msgSuccess.getText();
		}
		
}
