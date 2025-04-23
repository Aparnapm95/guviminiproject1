package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.BaseClass;

public class LoginTest extends BaseClass {
	@Test
    public void loginValidUser() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("Aparna1995", "Aparna@1995");

        assert driver.getPageSource().contains("Log out");
    }
}
