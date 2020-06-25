package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	WebElement EnterEmailInput;
	
	@FindBy (xpath  = "//button[@class='btn btn-primary btn-block next']")
	WebElement NextButton;
	
	@FindBy (id = "password")
	WebElement EnterPasswordInput;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block login']")
	WebElement LoginButton;
	
	@FindBy(id = "exampleModalCenterTitle")
	public WebElement CompleteProfilePopup;
	
	public void UserCanLogin(String Email , String Password)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SetElementText(EnterEmailInput, Email);
		ClickButton(NextButton);
		SetElementText(EnterPasswordInput, Password);
		ClickButton(LoginButton);
	}
}
