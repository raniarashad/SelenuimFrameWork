package tests;


import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase{

	HomePage HomeObject;
	LoginPage loginObject;
	
	
	@DataProvider(name ="UserLoginData")
	public static Object[][] LoginData_Valid (){
		return new Object[][]{
				{"rania.rashad2021@gmail.com","Rania123456"}};
	}
	
	
	@Test(dataProvider = "UserLoginData")
	public void UserLogin(String Email,String Password)
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenLoginPage();
		
		loginObject = new LoginPage(driver);
		loginObject.UserCanLogin(Email, Password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		AssertJUnit.assertTrue(loginObject.CompleteProfilePopup.isDisplayed());
		System.out.println("User logged in successfuly and you can complete your profile");
		
	}
}
