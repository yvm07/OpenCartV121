package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	// constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@value='0']")
	WebElement chkbNewsletter;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkbPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Action Methods
	public void fillFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void fillEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void fillTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}

	public void fillPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void fillConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}

	public void clickNewsletter() {
		chkbNewsletter.click();
	}

	public void clickPolicy() {
		chkbPolicy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getMsgConfirmation() {
		try {
			return (msgConfirmation.getText());
		} catch(Exception e)
		{
			return (e.getMessage());
		}
	}

}
