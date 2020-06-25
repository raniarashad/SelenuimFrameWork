package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends TestBase {

	HomePage HomeObject;
	RegisterPage RegisterObject;

	@DataProvider(name = "TestData_Valid")
	public static Object[][] UserDate_Valid ()
	{
		return new Object[][] {
			{"Tamer" , "Roshdy" , "Rashadta@gmail.com", "Rasha123456789"}};
			//{"Rania","Rashad", "rania.rashad2021@gmail.com", "Rania123456"}};
	}

	@DataProvider(name = "TestData_Invalid")
	public static Object[][] UserDate_Invalid ()
	{
		return new Object[][] {
			{"Rania" , "Rashad" , "rania.rashad2@gmail.com", "Rania123456"}};

	}


	@Test(dataProvider = "TestData_Valid" , enabled = true , priority = 0)
	public void MakeRegister (String firstname , String lastname , String Email , String Password)
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterPage();

		RegisterObject = new RegisterPage(driver);
		RegisterObject.UserCanMakeRegister(firstname, lastname, Email, Password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (RegisterObject.RegisterSuccessMsg.isDisplayed())
		{
			System.out.println("User registered successfuly");
		}
		else 
		{
			System.out.println("Faild! Registration test is faild");
		}
		//	Assert.assertEquals(RegisterObject.RegisterSuccessMsg.getText(), "تمت عملية التسجيل بنجاح! يرجى مراجعة بريدك الإلكتروني لإتمام عملية التحقق من عنوان بريدك الإلكتروني");
	}



	@Test (dataProvider  = "TestData_Invalid" , enabled = true , priority = 1)
	public void NegativeCaseArabicLang (String firstname , String lastname , String Email , String Password)
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterPage();

		RegisterObject = new RegisterPage(driver);
		RegisterObject.UserCanMakeRegister(firstname, lastname, Email, Password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(RegisterObject.ValidationMessageEmailExists.getText().contains("عنوان البريد الإلكتروني مستعمل"));
		System.out.println("Arabic validation email validation message is displayed successfully");

		//		assertEquals(RegisterObject.ValidationMessageEmailExists.getText(),"The E-mail has already been taken.");

	}

	@Test (dataProvider  = "TestData_Invalid" , enabled = true , priority = 2)
	public void NegativeCaseEnglishLang (String firstname , String lastname , String Email , String Password)
	{
		HomeObject = new HomePage(driver);
		HomeObject.OpenRegisterPage();
		HomeObject.ChangeWebsiteLanguage();

		RegisterObject = new RegisterPage(driver);
		RegisterObject.UserCanMakeRegister(firstname, lastname, Email, Password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(RegisterObject.ValidationMessageEmailExists.getText(),"The E-mail has already been taken.");
		System.out.println("English validation email message is displayed successfully");

	}
}
