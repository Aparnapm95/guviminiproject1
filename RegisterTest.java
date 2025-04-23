package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;
import utils.BaseClass;

public class RegisterTest extends BaseClass {
	 @Test
	    public void registerNewUser() {
	        HomePage home = new HomePage(driver);
	        home.clickRegister();

	        RegisterPage register = new RegisterPage(driver);
	        register.registerUser("female", "Aparna", "pm", "Aparna1995", "Aparna@1995");

	        assert driver.getPageSource().contains("Your registration completed");
	    }
}
