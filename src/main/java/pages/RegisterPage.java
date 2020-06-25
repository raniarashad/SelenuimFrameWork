package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "firstname")
	WebElement FirstNameInput;
	
	@FindBy(id = "lastname")
	WebElement LastNameInput;
	
	@FindBy(id = "email")
	WebElement EmailAddressInput;
	
	@FindBy(id  = "password")
	WebElement PasswordInput;
	
	@FindBy(id = "checkbox1")
	WebElement PrivacyPolicyCheckBox;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block register']")
	WebElement RegisterButton;
	
	@FindBy (xpath = "//div[@class='row text-center col-12 col-lg-6 mx-auto']")
	public WebElement RegisterSuccessMsg;
	
	@FindBy (css = "#signupForm > div.alert.alert-danger > p")
	public WebElement ValidationMessageEmailExists;
	
	public void UserCanMakeRegister (String firstname , String lastname , String Email , String Password)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SetElementText(FirstNameInput, firstname);
		SetElementText(LastNameInput, lastname);
		SetElementText(EmailAddressInput, Email);
		SetElementText(PasswordInput, Password);
		ClickButton(PrivacyPolicyCheckBox);
		ClickButton(RegisterButton);
	}
}
