package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//a[@href='https://www.gocardi.com/register']")
	WebElement RegisterLink;
	
	@FindBy (xpath =  "//a[@class='nav-link secLang']")
	WebElement EnglishLanguage;
	
	@FindBy (xpath = "//a[@href='https://www.gocardi.com/login']")
	WebElement LoginLink;
	
	public void OpenRegisterPage()
	{
		ClickButton(RegisterLink);;
	}
	
	public void ChangeWebsiteLanguage ()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ClickButton(EnglishLanguage);
	}
	
	public void OpenLoginPage()
	{
		ClickButton(LoginLink);
	}
}
